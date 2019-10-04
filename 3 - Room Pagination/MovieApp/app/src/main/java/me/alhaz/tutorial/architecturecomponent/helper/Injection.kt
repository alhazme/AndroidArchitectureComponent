package me.alhaz.tutorial.architecturecomponent.helper

import android.app.Application
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.MovieRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.MovieLocalRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.MovieRemoteRepository

class Injection {

    companion object {

        fun provideMovieRepository(application: Application): MovieRepository {
            val appExecutors = AppExecutors()
            val movieRemoteRepository = MovieRemoteRepository()
            val movieLocalRepository = MovieLocalRepository(application)
            val movieRepository = MovieRepository(appExecutors, movieRemoteRepository, movieLocalRepository)
            return movieRepository
        }
    }

}