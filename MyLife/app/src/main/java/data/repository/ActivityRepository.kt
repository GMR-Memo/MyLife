package data.repository


import com.example.mylife.data.local.ActivityDao
import data.model.ActivityEntity
import kotlinx.coroutines.flow.Flow

class ActivityRepository(
    private val activityDao: ActivityDao
) {

    val allActivities: Flow<List<ActivityEntity>> =
        activityDao.getAllActivities()

    suspend fun insert(activity: ActivityEntity) {
        activityDao.insertActivity(activity)
    }

    suspend fun delete(activity: ActivityEntity) {
        activityDao.deleteActivity(activity)
    }

    fun getActivitiesByDate(date: Long): Flow<List<ActivityEntity>> {
        return activityDao.getActivitiesByDate(date)
    }
}