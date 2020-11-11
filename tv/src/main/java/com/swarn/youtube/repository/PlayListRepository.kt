package com.swarn.youtube.repository

import androidx.lifecycle.MutableLiveData
import com.swarn.youtube.api.ApiClient
import com.swarn.youtube.api.YoutubeAPIService
import com.swarn.youtube.model.playlistitems.PlayListItems
import com.swarn.youtube.model.playlists.PlayLists
import com.swarn.youtube.vo.Resource
import io.reactivex.Flowable

/**
 * @author Swarn Singh.
 */

const val PLAYLIST_PART = "contentDetails,snippet,id,player,status"
const val PLAYLIST_ITEM_PART = "contentDetails,snippet,id,status"

object PlayListRepository {

    private val playLists: MutableLiveData<Resource<PlayLists>> by lazy { MutableLiveData() }

    private val youtubeAPIService: YoutubeAPIService by lazy {
        ApiClient.createService(YoutubeAPIService::class.java)
    }

    fun getYoutubePlayList(
        channelId: String,
        apiKey: String
    ): MutableLiveData<Resource<PlayLists>> {

        //TODO
        playLists.postValue(Resource.Loading())
        return playLists
    }

    private fun getPlayLists(
        channelId: String,
        apiKey: String
    ): Flowable<PlayLists> {

        return youtubeAPIService.getPlaylists(
            PLAYLIST_PART,
            channelId,
            apiKey
        )
    }

    private fun getPlayListItems(playListId: String, apiKey: String): Flowable<PlayListItems> {
        return youtubeAPIService.getPlayListItems(PLAYLIST_ITEM_PART, playListId, apiKey)
    }
}