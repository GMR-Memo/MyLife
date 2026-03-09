package com.example.mylife.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import data.local.AppDatabase
import data.model.ActivityEntity
import data.repository.ActivityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ActivityRepository

    val allActivities: Flow<List<ActivityEntity>>

    init {
        val dao = AppDatabase.getDatabase(application).activityDao()
        repository = ActivityRepository(dao)
        allActivities = repository.allActivities
    }

    fun insert(activity: ActivityEntity) {
        viewModelScope.launch {
            repository.insert(activity)
        }
    }

    fun delete(activity: ActivityEntity) {
        viewModelScope.launch {
            repository.delete(activity)
        }
    }

    fun getActivitiesByDate(date: Long): Flow<List<ActivityEntity>> {
        return repository.getActivitiesByDate(date)
    }
}