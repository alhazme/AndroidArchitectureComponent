package me.alhaz.tutorial.architecturecomponent.views.movies.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.databinding.RowMovieBinding
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity

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
        val layoutInflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<RowMovieBinding>(
            layoutInflater,
            R.layout.row_movie,
            parent,
            false
        )
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bindItem(movie, clickListener)
    }

}

class MovieListViewHolder(val binding: RowMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(movieEntity: MovieEntity?, clickListener: (MovieEntity) -> Unit) {
        movieEntity?.let { movie ->
            binding.movie = movie
            binding.root.setOnClickListener {
                clickListener(movie)
            }
        }
    }


}