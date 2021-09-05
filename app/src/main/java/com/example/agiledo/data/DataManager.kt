package com.example.agiledo.data

import com.example.agiledo.data.domain.Task

object DataManager {
    //region initilize variables
    val listOfTasks = mutableListOf<Task>()
    val tasks : List<Task>
        get() = listOfTasks.toList()
    //endregion

    //region add task
    /**
     * this function will call in HomeFragment to add new task to the list of task
     * @param task an Object of class Task that will add
     * @return nothing
     * @author Anwar
     */
    fun addTask( task : Task ) {
        listOfTasks.add(task)
    }
    //endregion

    //region delete task
    /**
     * this function will call in HomeFragment to delete a task from the list of task
     * @param index an Int representing the position of the deleted task
     * @return nothing
     * @author Anwar
     */
    fun deleteTaskAt(index: Int){
        listOfTasks.removeAt(index)
    }
    //endregion

}