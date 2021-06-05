package dev.darshn.trektrak.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM Run ORDER BY timeStamp DESC")
    fun getAllRunSortByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM Run ORDER BY duration DESC")
    fun getAllRunSortByTime(): LiveData<List<Run>>

    @Query("SELECT * FROM Run ORDER BY calories DESC")
    fun getAllRunSortByCalories(): LiveData<List<Run>>

    @Query("SELECT * FROM Run ORDER BY avgSpeed DESC")
    fun getAllRunSortByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM Run ORDER BY distance DESC")
    fun getAllRunSortByDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(duration) FROM Run")
    fun getTotalTime(): LiveData<Long>

    @Query("SELECT SUM(calories) FROM Run")
    fun getTotalCalories(): LiveData<Int>

    @Query("SELECT SUM(distance) FROM Run")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(avgSpeed) FROM Run")
    fun getAvgSpeed(): LiveData<Float>
}