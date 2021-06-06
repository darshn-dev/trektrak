package dev.darshn.trektrak.repositories

import dev.darshn.trektrak.db.Run
import dev.darshn.trektrak.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {

    suspend fun insertRun(run:Run) = runDao.insertRun(run)

    suspend fun deleteRun(run:Run) = runDao.deleteRun(run)

    fun getAllRunSortByDate() = runDao.getAllRunSortByDate()

    fun getAllRunSortByDistance() = runDao.getAllRunSortByDistance()

    fun getAllRunSortByTime() = runDao.getAllRunSortByTime()

    fun getAllRunSortBySpeed() = runDao.getAllRunSortByAvgSpeed()

    fun getAllRunSortByCalories() = runDao.getAllRunSortByCalories()

    fun getTotalAvgSpeed() = runDao.getAvgSpeed()

    fun getTotalCalories() = runDao.getTotalCalories()

    fun getTotalDistance() = runDao.getTotalDistance()

    fun getTotalTime() = runDao.getTotalTime()

}