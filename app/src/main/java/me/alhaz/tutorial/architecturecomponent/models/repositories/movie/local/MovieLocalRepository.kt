package me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local

import android.app.Application
import androidx.paging.DataSource
import me.alhaz.tutorial.architecturecomponent.models.database.MovieAppDatabase
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.dao.MovieEntityDAO
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity

class MovieLocalRepository(application: Application) {

    private var movieEntityDao: MovieEntityDAO

    init {
        val db = MovieAppDatabase.getInstance(application)
        movieEntityDao = db.movieDao()
    }

    fun getMovieList(): DataSource.Factory<Int, MovieEntity> {
        return movieEntityDao.getMovieList()
    }

    fun find(id: Long): MovieEntity {
        return movieEntityDao.find(id)
    }

    fun counts(): Int {
        return movieEntityDao.counts()
    }

    fun insert(movie: MovieEntity) {
        movieEntityDao.insert(movie)
    }

    fun deleteAll() {
        movieEntityDao.deleteAll()
    }

}