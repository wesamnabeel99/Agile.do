package com.example.agiledo.data

import android.content.ContentValues
import com.example.agiledo.data.domain.Task
import com.example.agiledo.utils.Constants

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
    fun addTask(task: Task) {
        listOfTasks.add(task)
        listOfTasks.groupBy {
            task.state
        }    }
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
            put(Constants.Database.STATE, task.state)

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
            Constants.Database.TASK_ASSIGNED_TO,
            Constants.Database.STATE

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
            val state = cursor.getString(Constants.CursorIndexes.STATE)
            task=Task(taskName,taskDesc,startDate,dueDate,author,state)

          // Log.i("MAIN_ACTIVITY", "$id - $taskName -$taskDesc -$startDate - $dueDate - $author")
        }
        return task


    }




    fun deleteTask( task : Task ) {
        listOfTasks.remove(task)
    }


//    fun filterList (task: Task) {
//        listOfTasks.groupBy {
//            task.state
//        }
//    }
}
