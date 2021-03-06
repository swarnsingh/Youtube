package com.swarn.youtube.model.playlists


import com.google.gson.annotations.SerializedName

data class Default(
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("width")
    val width: Int = 0
)