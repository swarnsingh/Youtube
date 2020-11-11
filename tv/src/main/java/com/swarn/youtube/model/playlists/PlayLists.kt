package com.swarn.youtube.model.playlists


import com.google.gson.annotations.SerializedName
import com.swarn.youtube.model.playlistitems.PlayListItems

data class PlayLists(
    @SerializedName("etag")
    val etag: String = "",
    @SerializedName("items")
    val items: List<Item> = listOf(),
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("nextPageToken")
    val nextPageToken: String = "",
    @SerializedName("pageInfo")
    val pageInfo: PageInfo = PageInfo(),

    var playListItems: List<PlayListItems>
)