package me.alhaz.tutorial.architecturecomponent.models.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.dao.MovieEntityDAO
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity

@Database(entities = arrayOf(MovieEntity::class), version = 1, exportSchema = false)
abstract class MovieAppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieEntityDAO
    // add other Daos here

    companion object {

        private const val DB_NAME = "movieapp.db"
        private var INSTANCE: MovieAppDatabase? = null

        fun getInstance(application: Application): MovieAppDatabase {
            if (INSTANCE == null) {
                synchronized(MovieAppDatabase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(application.applicationContext, MovieAppDatabase::class.java, DB_NAME).allowMainThreadQueries().build()
                    }
                }
            }
            return INSTANCE!!
        }

        fun dropInstance() {
            INSTANCE = null
        }

    }

}