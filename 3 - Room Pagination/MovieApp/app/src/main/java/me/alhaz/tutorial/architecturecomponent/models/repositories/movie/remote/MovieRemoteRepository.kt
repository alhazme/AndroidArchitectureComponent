package me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.alhaz.tutorial.architecturecomponent.BuildConfig
import me.alhaz.tutorial.architecturecomponent.helper.RetrofitConfig
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.ApiResponse
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteRepository {

    fun getListMovie(): LiveData<ApiResponse<ArrayList<Movie>>> {

        val moviesLiveData = MutableLiveData<ApiResponse<ArrayList<Movie>>>()

        RetrofitConfig().getMovieService().getListMovie(BuildConfig.API_KEY, BuildConfig.LANGUAGE).enqueue(object: Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    responseData?.let { moviePopularResponse ->
                        moviePopularResponse.results?.let { moviesResult ->
                            val movies = ArrayList<Movie>()
                            movies.addAll(moviesResult)
                            moviesLiveData.postValue(ApiResponse.success(movies))
                        }
                    }
                }
                else {
                    moviesLiveData.postValue(ApiResponse.error(response.message().toString(), null))
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                moviesLiveData.postValue(ApiResponse.error(t.localizedMessage, null))
            }
        })

        return moviesLiveData
    }

    fun getDetailMovie(movieID: Long): LiveData<ApiResponse<Movie>> {

        val movieLiveData = MutableLiveData<ApiResponse<Movie>>()
        RetrofitConfig().getMovieService().getDetailMovie(movieID, BuildConfig.API_KEY, BuildConfig.LANGUAGE).enqueue(object: Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    responseData?.let { movie ->
                        movieLiveData.postValue(ApiResponse.success(movie))
                    }
                }
                else {
                    movieLiveData.postValue(ApiResponse.error(response.message().toString(), null))
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                movieLiveData.postValue(ApiResponse.error(t.localizedMessage, null))
            }
        })
        return movieLiveData
    }

}