package me.alhaz.tutorial.architecturecomponent.views.movies.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*
import me.alhaz.tutorial.architecturecomponent.BuildConfig
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.detail.MovieDetailViewModel
import me.alhaz.tutorial.architecturecomponent.viewmodels.movies.factory.MovieViewModelFactory

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieDetailViewModel
    private var movieID: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

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
        viewModel.getMovieDetail(movieID).observe(this, Observer { movie ->
            showDetailData(movie)
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

    private fun showDetailData(movie: Movie) {
        svBackground.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        Glide.with(this).load(BuildConfig.BASE_IMAGE_URL + movie.posterPath).into(ivPhoto)
        tvYear.text = movie.releaseDate.split("-").get(0)
        tvTitle.text = movie.title
        tvScore.text = "Score"
        tvRating.text = "${movie.voteAverage}"
        tvRuntime.text = getRuntime(movie.runtime)
        tvDescription.text = movie.overview
    }

    private fun getRuntime(runtime: Long): String {
        val hour = (runtime / 60).toString().split(".").get(0)
        val minute = runtime.rem(60)
        return "${hour}h ${minute}m"
    }
}
