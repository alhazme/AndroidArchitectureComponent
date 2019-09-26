package me.alhaz.tutorial.architecturecomponent.views.movies.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.factory.MovieViewModelFactory
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.list.MovieListViewModel
import me.alhaz.tutorial.architecturecomponent.views.movies.detail.MovieDetailActivity

class MovieListActivity : AppCompatActivity() {

    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var viewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        setupLayout()
        setupAdapter()
        setupViewModel()
    }

    private fun obtainViewModel(activity: AppCompatActivity): MovieListViewModel {
        val factory = MovieViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(MovieListViewModel::class.java)
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel(this)
        viewModel.getListMovie().observe(this, Observer { data ->
            data?.let { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        response.data?.let { movies ->
                            progressBar.visibility = View.GONE
                            rvMovies.visibility = View.VISIBLE
                            movieListAdapter.submitList(movies)
                        }
                    }
                    Status.EMPTY -> {
                        progressBar.visibility = View.GONE
                        rvMovies.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        rvMovies.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setupLayout() {
        rvMovies.setHasFixedSize(true)
        rvMovies.layoutManager = LinearLayoutManager(this)
    }

    private fun setupAdapter() {
        movieListAdapter = MovieListAdapter(this, clickListener = { movie ->
            openDetailMoviePage(movie.id)
        })
        rvMovies.adapter = movieListAdapter
    }

    private fun openDetailMoviePage(movieID: Long) {
        Log.d("1234567890", "selected movie ID: ${movieID}")
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movie_id", movieID)
        startActivity(intent)
    }
}
