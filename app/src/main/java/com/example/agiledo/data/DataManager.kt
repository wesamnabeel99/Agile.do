package com.example.agiledo.data

import android.content.ContentValues
import com.example.agiledo.data.domain.Task
import com.example.agiledo.utils.Constants

object DataManager {
    // these functions for test only
    val listOfTasks = mutableListOf<Task>()



    fun addTask(task: Task) {
        listOfTasks.add(task)
    }

    /**
     * insert new values to the table Task in the database
     * @return Unit
     * @param Task , TaskDbHelper
     * @author Tamara Mouneer
     */


    fun addNewTask(task: Task, dbHelper: TaskDbHelper) {
        val newEntry = ContentValues().apply {

            put(Constants.Database.TASK_NAME, task.taskName)
            put(Constants.Database.TASK_DESCRIPTION, task.taskDescription)
            put(Constants.Database.TASK_START_DATE, task.taskStartDate)
            put(Constants.Database.TASK_DUE_DATE, task.taskDueDate)
            put(Constants.Database.TASK_ASSIGNED_TO, task.taskAssignedTo)

        }

        dbHelper.writableDatabase.insert(Constants.Database.TABLE_NAME, null, newEntry)


    }


    /**
     * read all values in columns of Task table in database , by put the variables that refer to column names in array and pass into the dbHelper.readableDatabase.query
     * save the values of cursor object(the values of columns Task tAble) in object of Task
     * @return Task
     * @param TaskDbHelper
     * @author Tamara Mouneer
     */

    fun readTask(dbHelper: TaskDbHelper):Task {
        lateinit var task:Task
        val projection = arrayOf(
            Constants.Database.TASK_ID,
            Constants.Database.TASK_NAME,
            Constants.Database.TASK_DESCRIPTION,
            Constants.Database.TASK_START_DATE,
            Constants.Database.TASK_DUE_DATE,
            Constants.Database.TASK_ASSIGNED_TO
        ) //the array of columns
        val cursor =
            dbHelper.readableDatabase.query(Constants.Database.TABLE_NAME, projection, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(Constants.CursorIndexes.TASK_ID)
            val taskName = cursor.getString(Constants.CursorIndexes.TASK_NAME)
            val taskDesc = cursor.getString(Constants.CursorIndexes.TASK_DESCRIPTION)
            val startDate = cursor.getString(Constants.CursorIndexes.TASK_START_DATE)
            val dueDate = cursor.getString(Constants.CursorIndexes.TASK_DUE_DATE)
            val author = cursor.getString(Constants.CursorIndexes.TASK_ASSIGNED_TO)
             task=Task(taskName,taskDesc,startDate,dueDate,author)

          // Log.i("MAIN_ACTIVITY", "$id - $taskName -$taskDesc -$startDate - $dueDate - $author")
        }
        return task


    }




}