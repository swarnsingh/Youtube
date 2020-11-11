package com.swarn.youtube.model.playlistitems


import com.google.gson.annotations.SerializedName

data class Maxres(
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("width")
    val width: Int = 0
)