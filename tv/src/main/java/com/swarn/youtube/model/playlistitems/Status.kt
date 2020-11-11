package com.swarn.youtube.model.playlistitems


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("privacyStatus")
    val privacyStatus: String = ""
)