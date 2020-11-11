package com.swarn.youtube.api

import com.swarn.youtube.model.playlistitems.PlayListItems
import com.swarn.youtube.model.playlists.PlayLists
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Swarn Singh.
 */
interface YoutubeAPIService {

    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String
    ): Flowable<PlayLists>

    @GET("playlistItems")
    fun getPlayListItems(
        @Query("part") part: String,
        @Query("playlistId") playListId: String,
        @Query("key") key: String
    ): Flowable<PlayListItems>
}