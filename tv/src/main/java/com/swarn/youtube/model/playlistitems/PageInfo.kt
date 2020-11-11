package com.swarn.youtube.model.playlistitems


import com.google.gson.annotations.SerializedName

data class PageInfo(
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int = 0,
    @SerializedName("totalResults")
    val totalResults: Int = 0
)