package me.alhaz.tutorial.architecturecomponent.models.repositories.movie

import androidx.lifecycle.MutableLiveData
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie

interface MovieDataSource {
    fun getListMovie(): MutableLiveData<ArrayList<Movie>>
    fun getDetailMovie(movieID: Long): MutableLiveData<Movie>
}