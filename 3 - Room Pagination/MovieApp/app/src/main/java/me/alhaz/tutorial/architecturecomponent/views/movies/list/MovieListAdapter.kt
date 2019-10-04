package me.alhaz.tutorial.architecturecomponent.views.movies.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.alhaz.tutorial.architecturecomponent.BuildConfig
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie

class MovieListAdapter(val context: Context, val clickListener: (MovieEntity) -> Unit) : PagedListAdapter<MovieEntity, MovieListViewHolder>(diffCallback) {

    // For Pagination

    companion object {
        private val diffCallback = object: DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.row_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bindItem(context, holder.itemView, movie, clickListener)
    }

}

class MovieListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvYear: TextView = view.findViewById(R.id.tv_year)
    private val tvTitle: TextView = view.findViewById(R.id.tv_title)
    private val tvRating: TextView = view.findViewById(R.id.tv_rating)
    private val tvRuntime: TextView = view.findViewById(R.id.tv_runtime)
    private val tvDescription: TextView = view.findViewById(R.id.tv_description)
    private val ivPhoto: ImageView = view.findViewById(R.id.iv_photo)

    fun bindItem(context: Context, view: View, movieEntity: MovieEntity?, clickListener: (MovieEntity) -> Unit) {
        movieEntity?.let { movie ->
            tvYear.text = movie.releaseDate.split("-").get(0)
            tvTitle.text = movie.title
            tvRating.text = "${movie.voteAverage}"
            tvRuntime.text = getRuntime(movie.runtime)
            tvDescription.text = movie.overview

            Glide.with(context).load(BuildConfig.BASE_IMAGE_URL + movie.posterPath).into(ivPhoto)
            view.setOnClickListener {
                clickListener(movie)
            }
        }
    }

    private fun getRuntime(runtime: Long): String {
        val hour = (runtime / 60).toString().split(".").get(0)
        val minute = runtime.rem(60)
        return "${hour}h ${minute}m"
    }


}