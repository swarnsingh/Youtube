package com.swarn.youtube.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.swarn.youtube.model.playlists.Item
import com.swarn.youtube.repository.PlayListRepository
import com.swarn.youtube.vo.Resource

/**
 * @author Swarn Singh.
 */
class PlayListViewModel : ViewModel() {

    fun getYoutubePlayList(channelId: String, apiKey: String): LiveData<Resource<List<Item>>> {
        return PlayListRepository.getYoutubePlayList(channelId, apiKey)
    }
}