package me.alhaz.tutorial.architecturecomponent.viewmodels.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.MovieRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie

class MovieDetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private var movie = MutableLiveData<Movie>()

    fun getMovieDetail(movieID: Long): LiveData<Movie> {
        movie = movieRepository.getDetailMovie(movieID)
        return movie
    }
}