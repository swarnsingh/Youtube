package com.swarn.youtube.model.playlists


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("contentDetails")
    val contentDetails: ContentDetails = ContentDetails(),
    @SerializedName("etag")
    val etag: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("snippet")
    val snippet: Snippet = Snippet()
)