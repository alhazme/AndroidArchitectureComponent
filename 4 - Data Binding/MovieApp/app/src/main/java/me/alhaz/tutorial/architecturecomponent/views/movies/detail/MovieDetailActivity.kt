package me.alhaz.tutorial.architecturecomponent.views.movies.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.databinding.ActivityMovieDetailBinding
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.detail.MovieDetailViewModel
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.factory.MovieViewModelFactory


class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel
    private var movieID: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)

        setupLayout()
        getIntentData()
        setupViewModel()
    }

    private fun getIntentData() {
        intent.extras?.let { bundle ->
            movieID = bundle.getLong("movie_id")
        }
    }

    private fun obtainViewModel(): MovieDetailViewModel {
        val factory = MovieViewModelFactory.getInstance(this.application)
        return ViewModelProviders.of(this, factory).get(MovieDetailViewModel::class.java)
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel()
        binding.viewModel = viewModel
        viewModel.getMovieDetail(movieID).observe(this, Observer { movie ->
            binding.apply {
                svBackground.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun setupLayout() {
        title = "Detail"
        getSupportActionBar()?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
