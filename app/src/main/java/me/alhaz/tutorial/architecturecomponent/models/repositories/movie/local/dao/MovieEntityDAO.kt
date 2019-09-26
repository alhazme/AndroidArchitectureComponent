package me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.local.entity.MovieEntity

@Dao
interface MovieEntityDAO {

    // 1. Select All
    @Query("SELECT * FROM movie ORDER BY id ASC")
    fun getMovieList(): DataSource.Factory<Int, MovieEntity>

    // 2. Select by ID
    @Query("SELECT * FROM movie WHERE id = :id")
    fun find(id: Long): MovieEntity

    // 3. Get People count
    @Query("SELECT COUNT(*) from movie")
    fun counts(): Int

    // 4. Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity)

    // 5. Delete All
    @Query("DELETE FROM movie")
    fun deleteAll()

}