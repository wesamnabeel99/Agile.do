package com.example.agiledo.data

import android.content.ContentValues
import com.example.agiledo.data.domain.Task
import com.example.agiledo.utils.Constants

object DataManager {
    //region initilize variables
    val tasksFromTable= mutableListOf<Task>()
    val tasks:List<Task>
    get()= tasksFromTable.toList()
    //endregion

    //region add task
    /**
     * this function will call in HomeFragment to add new task to the list of task
     * @param task an Object of class Task that will add
     * @return nothing
     * @author Anwar
     */
    fun addTask(task: Task) {
        tasksFromTable.add(task)
        addNewTaskToDatabase(task)
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
        var currentTask:Task= tasksFromTable[index]
        tasksFromTable.removeAt(index)
        deleteTask(currentTask.id)
    }
    //endregion

    /**
     * insert new values to the table Task in the database
     * @return Unit
     * @param Task , TaskDbHelper
     * @author Tamara Mouneer
     */


    fun addNewTaskToDatabase(task: Task) {
        val newEntry = ContentValues().apply {

            put("id",task.id)
            put(Constants.Database.TASK_NAME, task.taskName)
            put(Constants.Database.TASK_DESCRIPTION, task.taskDescription)
            put(Constants.Database.TASK_START_DATE, task.taskStartDate)
            put(Constants.Database.TASK_DUE_DATE, task.taskDueDate)
            put(Constants.Database.TASK_ASSIGNED_TO, task.taskAssignedTo)

        }

        Constants.dbHelper.writableDatabase.insert(Constants.Database.TABLE_NAME, null, newEntry)


    }


    /**
     * read all values in columns of Task table in database , by put the variables that refer to column names in array and pass into the dbHelper.readableDatabase.query
     * save the values of cursor object(the values of columns Task tAble) in object of Task
     * save all object in mutaleList of Task()
     * @return Nothing
     * @param TaskDbHelper
     * @author Tamara Mouneer , mohammed ali
     */

    fun readTask(dbHelper: TaskDbHelper){
        lateinit var task: Task
        val projection = arrayOf(
            Constants.Database.TASK_ID,
            Constants.Database.TASK_NAME,
            Constants.Database.TASK_DESCRIPTION,
            Constants.Database.TASK_START_DATE,
            Constants.Database.TASK_DUE_DATE,
            Constants.Database.TASK_ASSIGNED_TO
        ) //the array of columns
        val cursor =
            dbHelper.readableDatabase.query(
                Constants.Database.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )
        while (cursor.moveToNext()) {
            val id = cursor.getInt(Constants.CursorIndexes.TASK_ID)
            val taskName = cursor.getString(Constants.CursorIndexes.TASK_NAME)
            val taskDesc = cursor.getString(Constants.CursorIndexes.TASK_DESCRIPTION)
            val startDate = cursor.getString(Constants.CursorIndexes.TASK_START_DATE)
            val dueDate = cursor.getString(Constants.CursorIndexes.TASK_DUE_DATE)
            val author = cursor.getString(Constants.CursorIndexes.TASK_ASSIGNED_TO)
            tasksFromTable.add(Task(Constants.taskId++,taskName, taskDesc, startDate, dueDate, author))

        }
    }




    fun deleteTask(id:Int) {
        Constants.dbHelper.writableDatabase.delete(Constants.Database.TABLE_NAME,"${Constants.Database.TASK_ID}=?", arrayOf<String>("$id"))
    }


}