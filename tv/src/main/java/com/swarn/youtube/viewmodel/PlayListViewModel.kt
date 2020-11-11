package com.swarn.youtube.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swarn.youtube.model.playlists.PlayLists
import com.swarn.youtube.repository.PlayListRepository
import com.swarn.youtube.vo.Resource

/**
 * @author Swarn Singh.
 */
class PlayListViewModel : ViewModel() {

    fun getYoutubePlayList(channelId: String, apiKey : String): MutableLiveData<Resource<PlayLists>> {
        return PlayListRepository.getYoutubePlayList(channelId, apiKey)
    }
}