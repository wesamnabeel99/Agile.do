package com.example.agiledo.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TaskDbHelper(context:Context) :SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {



    override fun onCreate(sqliteDatabase: SQLiteDatabase?) {
       val createTable="CREATE TABLE ${DB.TABLE_NAME} (" +
               "   ${DB.ID} INTEGER PRIMARY KEY," +
               "   ${DB.TASK_NAME} TEXT," +
               "   ${DB.TaskDescription} TEXT," +
               "   ${DB.START_DATE} TEXT," +
               "   ${DB.DUE_DATE} TEXT," +
               " ${DB.ASSIGNED_TO} TEXT)"

            sqliteDatabase!!.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object{

        private const val DB_NAME="KANBAN BOARD DATABASE"
        private const val DB_VERSION=1


    }
}