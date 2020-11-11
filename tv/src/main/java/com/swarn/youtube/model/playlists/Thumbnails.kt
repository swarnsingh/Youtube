package com.swarn.youtube.model.playlists


import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("default")
    val default: Default = Default(),
    @SerializedName("high")
    val high: High = High(),
    @SerializedName("maxres")
    val maxres: Maxres = Maxres(),
    @SerializedName("medium")
    val medium: Medium = Medium(),
    @SerializedName("standard")
    val standard: Standard = Standard()
)