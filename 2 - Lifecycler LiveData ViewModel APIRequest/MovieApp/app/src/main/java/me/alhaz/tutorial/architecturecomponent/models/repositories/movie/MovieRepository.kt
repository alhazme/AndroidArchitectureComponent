package me.alhaz.tutorial.architecturecomponent.models.repositories.movie

import androidx.lifecycle.MutableLiveData
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.MovieRemoteRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie

class MovieRepository(private val movieRemoteRepository: MovieRemoteRepository): MovieDataSource {

    override fun getListMovie(): MutableLiveData<ArrayList<Movie>> {
        return movieRemoteRepository.getListMovie()
    }

    override fun getDetailMovie(movieID: Long): MutableLiveData<Movie> {
        return movieRemoteRepository.getDetailMovie(movieID)
    }

}