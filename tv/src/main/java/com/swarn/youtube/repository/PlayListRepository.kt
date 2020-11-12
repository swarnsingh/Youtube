package com.swarn.youtube.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swarn.youtube.api.ApiClient
import com.swarn.youtube.api.YoutubeAPIService
import com.swarn.youtube.model.playlists.Item
import com.swarn.youtube.vo.Resource
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * @author Swarn Singh.
 */

const val PLAYLIST_PART = "contentDetails,snippet,id,player,status"
const val PLAYLIST_ITEM_PART = "contentDetails,snippet,id,status"

object PlayListRepository {

    private val playListsLiveData: LiveData<Resource<List<Item>>>
        get() = playListsMutableLiveData

    private val playListsMutableLiveData: MutableLiveData<Resource<List<Item>>> by lazy {
        MutableLiveData()
    }

    private val youtubeAPIService: YoutubeAPIService by lazy {
        ApiClient.createService(YoutubeAPIService::class.java)
    }

    fun getYoutubePlayList(
        channelId: String,
        apiKey: String
    ): LiveData<Resource<List<Item>>> {

        var playLists = ArrayList<Item>()

        getPlayLists(channelId, apiKey)
            .subscribeOn(Schedulers.io())
            .flatMap {
                getPlayListItems(it, apiKey)
            }.subscribe(
                {
                    playLists.add(it)
                },
                {
                    playListsMutableLiveData.postValue(Resource.Error(it.localizedMessage))
                },
                {
                    playListsMutableLiveData.postValue(Resource.Success(playLists))
                }
            )
        playListsMutableLiveData.postValue(Resource.Loading())
        return playListsLiveData
    }

    private fun getPlayLists(
        channelId: String,
        apiKey: String
    ): Observable<Item> {
        return youtubeAPIService.getPlaylists(
            PLAYLIST_PART,
            channelId,
            apiKey
        ).flatMap {
            Observable.fromIterable(it.items)
                .subscribeOn(Schedulers.io())
        }
    }

    private fun getPlayListItems(item: Item, apiKey: String): Observable<Item> {
        return youtubeAPIService.getPlayListItems(PLAYLIST_ITEM_PART, item.id, apiKey)
            .subscribeOn(Schedulers.io())
            .map {
                item.playListItems = it
                item
            }
    }
}