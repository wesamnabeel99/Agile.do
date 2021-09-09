package com.example.agiledo.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.agiledo.utils.Constants
import java.io.Serializable

class TaskDbHelper(context:Context) :SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION),Serializable {


    /**
     * create sql query create new table with columns
     * @return Unit
     * @param sqliteDatabase pass database
     * @author Tamara Mouneer
     */
    override fun onCreate(sqliteDatabase: SQLiteDatabase?) {
       val createTable="CREATE TABLE ${Constants.Database.TABLE_NAME} (" +
               "   ${Constants.Database.TASK_ID} INTEGER," +
               "   ${Constants.Database.TASK_NAME} TEXT," +
               "   ${Constants.Database.TASK_DESCRIPTION} TEXT," +
               "   ${Constants.Database.TASK_START_DATE} TEXT," +
               "   ${Constants.Database.TASK_DUE_DATE} TEXT," +
               " ${Constants.Database.TASK_ASSIGNED_TO} TEXT)"

            sqliteDatabase?.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
//TODO
    }

    companion object{

        private const val DB_NAME="KANBAN BOARD DATABASE"
        private const val DB_VERSION=1


    }
}