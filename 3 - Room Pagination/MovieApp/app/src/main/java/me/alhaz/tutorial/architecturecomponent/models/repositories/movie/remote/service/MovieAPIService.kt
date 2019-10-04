package me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.service

import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPIService {

    @GET("discover/movie")
    fun getListMovie(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movie_id: Long,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Call<Movie>
}