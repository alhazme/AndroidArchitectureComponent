package me.alhaz.tutorial.architecturecomponent.models.repositories.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import me.alhaz.tutorial.architecturecomponent.helper.AppExecutors
import me.alhaz.tutorial.architecturecomponent.helper.NetworkBoundResource
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.ApiResponse
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Resource
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.MovieLocalRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.MovieRemoteRepository
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie

class MovieRepository(private val appExecutors: AppExecutors, private val movieRemoteRepository: MovieRemoteRepository, private val movieLocalRepository: MovieLocalRepository): MovieDataSource {

    override fun getListMovie(): LiveData<Resource<PagedList<MovieEntity>>> {

        return object: NetworkBoundResource<PagedList<MovieEntity>, ArrayList<Movie>>(appExecutors) {

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return (movieLocalRepository.counts() == 0)
            }

            override fun createCall(): LiveData<ApiResponse<ArrayList<Movie>>> {
                return movieRemoteRepository.getListMovie()
            }

            override fun saveCallResult(item: ArrayList<Movie>) {
                item.forEach { movie ->
                    val movieEntity = MovieEntity(
                        id = movie.id,
                        title = movie.title,
                        voteAverage = movie.voteAverage,
                        overview = movie.overview,
                        releaseDate = movie.releaseDate,
                        runtime = movie.runtime,
                        posterPath = movie.posterPath
                    )
                    movieLocalRepository.insert(movieEntity)
                }
            }

            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                return LivePagedListBuilder(movieLocalRepository.getMovieList(), 10).build()
            }

        }.asLiveData()
    }

    override fun getDetailMovie(movieID: Long): MovieEntity {
        return movieLocalRepository.find(movieID)
    }

}