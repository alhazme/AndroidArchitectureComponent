package me.alhaz.tutorial.architecturecomponent.views.movies.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.models.database.DataDummy
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie
import me.alhaz.tutorial.architecturecomponent.views.movies.detail.MovieDetailActivity

class MovieListActivity : AppCompatActivity() {

    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var movies: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        setupData()
        setupLayout()
    }

    fun setupData() {
        movies = DataDummy.generateListMovie()
    }

    fun setupLayout() {
        rvMovies.setHasFixedSize(true)
        rvMovies.layoutManager = LinearLayoutManager(this)
        movieListAdapter = MovieListAdapter(this, movies, clickListener = { movie ->
            openDetailMoviePage(movie)
        })
        rvMovies.adapter = movieListAdapter
        if (movies.size > 0) {
            progressBar.visibility = View.GONE
            rvMovies.visibility = View.VISIBLE
        }
        else {
            progressBar.visibility = View.VISIBLE
            rvMovies.visibility = View.GONE
        }
    }

    fun openDetailMoviePage(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }
}
