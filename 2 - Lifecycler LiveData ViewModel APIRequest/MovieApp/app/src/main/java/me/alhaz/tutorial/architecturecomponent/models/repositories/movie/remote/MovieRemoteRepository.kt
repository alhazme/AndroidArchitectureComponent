package me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote

import androidx.lifecycle.MutableLiveData
import me.alhaz.tutorial.architecturecomponent.BuildConfig
import me.alhaz.tutorial.architecturecomponent.helper.RetrofitConfig
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteRepository {

    fun getListMovie(): MutableLiveData<ArrayList<Movie>> {

        val movies = MutableLiveData<ArrayList<Movie>>()

        RetrofitConfig().getMovieService().getListMovie(BuildConfig.API_KEY, BuildConfig.LANGUAGE).enqueue(object:
            Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movieResponses = ArrayList<Movie>()
                    val responseData = response.body()
                    responseData?.let {
                        val moviePopularResponse: MovieResponse = it
                        moviePopularResponse.results?.let {
                            val data: List<Movie> = it
                            if (data.isNotEmpty()) {
                                data.forEach {
                                    movieResponses.add(it)
                                }
                            }
                        }
                    }
                    movies.postValue(movieResponses)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
        })

        return movies
    }

    fun getDetailMovie(movieID: Long): MutableLiveData<Movie> {

        var movie = MutableLiveData<Movie>()

        RetrofitConfig().getMovieService().getDetailMovie(movieID, BuildConfig.API_KEY, BuildConfig.LANGUAGE).enqueue(object: Callback<Movie> {

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    responseData?.let {
                        movie.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return movie
    }

}