package me.alhaz.tutorial.architecturecomponent.views.movies.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.databinding.ActivityMovieListBinding
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.SUCCESS
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.ERROR
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.EMPTY
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.factory.MovieViewModelFactory
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.list.MovieListViewModel
import me.alhaz.tutorial.architecturecomponent.views.movies.detail.MovieDetailActivity

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)

        setupLayout()
        setupAdapter()
        setupViewModel()
    }

    fun setupLayout() {
        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
    }

    fun setupAdapter() {
        movieListAdapter = MovieListAdapter(this, clickListener = { movie ->
            openDetailMoviePage(movie.id)
        })
        binding.rvMovies.adapter = movieListAdapter
    }

    private fun obtainViewModel(): MovieListViewModel {
        val factory = MovieViewModelFactory.getInstance(this.application)
        return ViewModelProviders.of(this, factory).get(MovieListViewModel::class.java)
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel()
        viewModel.getListMovie().observe(this, Observer { data ->
            data?.let { response ->
                when (response.status) {
                    SUCCESS -> {
                        response.data?.let { movies ->
                            binding.progressBar.visibility = View.GONE
                            binding.rvMovies.visibility = View.VISIBLE
                            movieListAdapter.submitList(movies)
                        }
                    }
                    EMPTY -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvMovies.visibility = View.GONE
                    }
                    ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvMovies.visibility = View.GONE
                    }
                }
            }
        })
    }


    fun openDetailMoviePage(movieID: Long) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movie_id", movieID)
        startActivity(intent)
    }
}
