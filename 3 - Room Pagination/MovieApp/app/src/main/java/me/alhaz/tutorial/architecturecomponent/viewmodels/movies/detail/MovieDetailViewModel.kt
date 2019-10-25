package me.alhaz.tutorial.architecturecomponent.viewmodels.movies.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.MovieRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity

class MovieDetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    var movie = MutableLiveData<MovieEntity>()

    fun getMovieDetail(movieID: Long): MutableLiveData<MovieEntity> {
        val movieEntity = movieRepository.getDetailMovie(movieID)
        movie.postValue(movieEntity)
        return movie
    }

}