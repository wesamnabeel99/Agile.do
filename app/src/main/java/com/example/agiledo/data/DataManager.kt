package com.example.agiledo.data

import android.content.ContentValues
import com.example.agiledo.data.domain.Task

object DataManager {
    // these functions for test only
    val listOfTasks = mutableListOf<Task>()
    lateinit var dbHelper:TaskDbHelper


    fun addTask( task : Task ) {
        listOfTasks.add(task)
    }
    /**
    addnewtask function will add data to all columns in database
     * return nothing
     ** author Tamara Mouneer


     **/



    fun addNewTask(taskName:String,taskDesc:String,startDate:String,dueDate:String,author:String)
    {
        val newEntry=ContentValues().apply {

            put(DB.TASK_NAME,taskName)
            put(DB.TaskDescription,taskDesc)
            put(DB.START_DATE,startDate)
            put(DB.DUE_DATE,dueDate)
            put(DB.ASSIGNED_TO,author)

        }

        dbHelper.writableDatabase.insert(DB.TABLE_NAME,null,newEntry)


    }


    /**
    readtask function will read all the data in Database without conditionsor where clause it equal to (select * from tableName)
     * return nothing
     ** author Tamara Mouneer


     **/


    fun readTask()
    {
        val projection =arrayOf(DB.ID , DB.TASK_NAME,DB.TaskDescription,DB.START_DATE,DB.DUE_DATE,DB.ASSIGNED_TO) //the array of columns
        //  val selection =""   //The columns for the WHERE clause
        //  val selectionArgs=""   //The values for the WHERE clause
        //  val sortOrder=""
        val cursor = dbHelper.readableDatabase.query(DB.TABLE_NAME,projection,null,null,null,null,null)
        while(cursor.moveToNext()){
            val id =cursor.getInt(0)
            val taskName =cursor.getString(1)
            val taskDesc =cursor.getString(2)
            val startDate =cursor.getString(3)
            val dueDate =cursor.getString(4)
            val author=cursor.getString(5)

            //log.i  or set them to xml values
        }


    }


}