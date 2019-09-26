package me.alhaz.tutorial.architecturecomponent.models.repositories.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Resource
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity

interface MovieDataSource {

    fun getListMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(movieID: Long): MovieEntity

}