package me.alhaz.tutorial.architecturecomponent.helper

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import me.alhaz.tutorial.architecturecomponent.BuildConfig

object DataBindingAdapter {

    @JvmStatic @BindingAdapter("poster")
    fun loadImageByURL(imageView: ImageView, posterPath: String?) {
        posterPath?.let {
            Glide.with(imageView.context).load(BuildConfig.BASE_IMAGE_URL + posterPath).into(imageView)
        }
    }

    @JvmStatic @BindingAdapter("year")
    fun loadYear(textView: TextView, releaseDate: String?) {
        releaseDate?.let {
            textView.text = releaseDate.split("-").get(0)
        }
    }

    @JvmStatic @BindingAdapter("runtime")
    fun loadRuntime(textView: TextView, runtime: Long?) {
        var time = "-"
        runtime?.let {
            if (runtime > 0) {
                val hour = (runtime / 60).toString().split(".").get(0)
                val minute = runtime.rem(60)
                time = "${hour}h ${minute}m"
            }
        }
        textView.text = time
    }

    @JvmStatic @BindingAdapter("rating")
    fun loadRating(textView: TextView, voteAverage: Double?) {
        voteAverage?.let {
            textView.text = "${voteAverage}"
        }
    }

}