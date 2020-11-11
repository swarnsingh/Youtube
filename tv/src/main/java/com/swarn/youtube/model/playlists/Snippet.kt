package com.swarn.youtube.model.playlists


import com.google.gson.annotations.SerializedName

data class Snippet(
    @SerializedName("channelId")
    val channelId: String = "",
    @SerializedName("channelTitle")
    val channelTitle: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("localized")
    val localized: Localized = Localized(),
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails = Thumbnails(),
    @SerializedName("title")
    val title: String = ""
)