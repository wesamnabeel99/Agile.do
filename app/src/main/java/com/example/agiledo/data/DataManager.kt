package com.example.agiledo.data

import com.example.agiledo.data.domain.Task

object DataManager {
    // these functions for test only
    val listOfTasks = mutableListOf<Task>()

    fun addTask( task : Task ) {
        listOfTasks.add(task)
    }

    fun deleteTask( task : Task ) {
        listOfTasks.remove(task)
    }

}