package me.alhaz.tutorial.architecturecomponent.viewmodels.movies.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.MovieRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie

class MovieListViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private var movies = MutableLiveData<ArrayList<Movie>>()

    fun getListMovie(): LiveData<ArrayList<Movie>> {
        movies = movieRepository.getListMovie()
        return movies
    }

}