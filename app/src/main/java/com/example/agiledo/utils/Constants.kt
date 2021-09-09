package com.example.agiledo.utils

import android.content.Context
import com.example.agiledo.data.TaskDbHelper

object Constants {
    lateinit var dbHelper:TaskDbHelper
    fun createTable(context:Context){
        dbHelper=TaskDbHelper(context)
    }
    object Database {
        const val TABLE_NAME = "TASKS"
        const val TASK_ID = "id"
        const val TASK_NAME = "taskName"
        const val TASK_DESCRIPTION = "taskDescription"
        const val TASK_START_DATE = "startDate"
        const val TASK_DUE_DATE = "dueDate"
        const val TASK_ASSIGNED_TO = "assignedTo"


    }
    object CursorIndexes{
        const val TASK_ID=0

        const val TASK_NAME = 1
        const val TASK_DESCRIPTION = 2
        const val TASK_START_DATE = 3
        const val TASK_DUE_DATE = 4
        const val TASK_ASSIGNED_TO=5




    }



    }