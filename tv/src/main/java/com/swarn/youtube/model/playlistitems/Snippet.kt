package com.swarn.youtube.model.playlistitems


import com.google.gson.annotations.SerializedName

data class Snippet(
    @SerializedName("channelId")
    val channelId: String = "",
    @SerializedName("channelTitle")
    val channelTitle: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("playlistId")
    val playlistId: String = "",
    @SerializedName("position")
    val position: Int = 0,
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("resourceId")
    val resourceId: ResourceId = ResourceId(),
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails = Thumbnails(),
    @SerializedName("title")
    val title: String = ""
)