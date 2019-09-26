package me.alhaz.tutorial.architecturecomponent.viewmodels.movies.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.alhaz.tutorial.architecturecomponent.helper.Injection
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.MovieRepository
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.detail.MovieDetailViewModel
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.list.MovieListViewModel

class MovieViewModelFactory private constructor(private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {

        @Volatile
        private var INSTANCE: MovieViewModelFactory? = null

        fun getInstance(application: Application): MovieViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(MovieViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            MovieViewModelFactory(
                                Injection.provideMovieRepository(application)
                            )
                    }
                }
            }
            return INSTANCE
        }

    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            return MovieListViewModel(movieRepository) as T
        }
        else if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            return MovieDetailViewModel(movieRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}