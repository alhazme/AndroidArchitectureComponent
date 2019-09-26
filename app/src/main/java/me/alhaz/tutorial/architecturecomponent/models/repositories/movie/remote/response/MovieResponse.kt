package me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse (

    @SerializedName("page")
    var page: Int = 1,

    @SerializedName("total_results")
    var totalResults: Int = 0,

    @SerializedName("total_pages")
    var totalPages: Int = 0,

    @SerializedName("results")
    var results: List<Movie>? = null

): Parcelable