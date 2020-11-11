package com.swarn.youtube.model.playlistitems


import com.google.gson.annotations.SerializedName

data class PlayListItems(
    @SerializedName("etag")
    val etag: String = "",
    @SerializedName("items")
    val items: List<Item> = listOf(),
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("nextPageToken")
    val nextPageToken: String = "",
    @SerializedName("pageInfo")
    val pageInfo: PageInfo = PageInfo()
)