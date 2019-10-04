package me.alhaz.tutorial.architecturecomponent.helper

import android.app.Application
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.MovieRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.MovieRemoteRepository

class Injection {

    companion object {

        fun provideMovieRepository(application: Application): MovieRepository {
            val movieRemoteRepository = MovieRemoteRepository()
            val movieRepository = MovieRepository(movieRemoteRepository)
            return movieRepository
        }

    }

}