package com.swarn.youtube.model.playlists


import com.google.gson.annotations.SerializedName

data class ContentDetails(
    @SerializedName("itemCount")
    val itemCount: Int = 0
)