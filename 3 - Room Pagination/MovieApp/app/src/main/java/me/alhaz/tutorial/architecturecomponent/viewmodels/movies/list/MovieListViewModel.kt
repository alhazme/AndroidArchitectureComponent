package me.alhaz.tutorial.architecturecomponent.viewmodels.movies.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Resource
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.MovieRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity

class MovieListViewModel(private val movieRepository: MovieRepository): ViewModel() {

    var movies: LiveData<Resource<PagedList<MovieEntity>>> = MutableLiveData()

    fun getListMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        movies = movieRepository.getListMovie()
        return movies
    }

}