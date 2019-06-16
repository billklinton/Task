package com.example.task.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.task.constants.DataBaseConstants

class TaskDataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "task.db"
    }
    private val createTableUser = """CREATE TABLE ${DataBaseConstants.USER.TABLE_NAME} (
        ${DataBaseConstants.USER.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
         ${DataBaseConstants.USER.COLUMNS.NAME} TEXT,
         ${DataBaseConstants.USER.COLUMNS.EMAIL} TEXT,
         ${DataBaseConstants.USER.COLUMNS.PASSWORD} TEXT
        );
    """

    private val createTableTask = """CREATE TABLE ${DataBaseConstants.USER.TABLE_NAME} (
        ${DataBaseConstants.USER.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
         ${DataBaseConstants.USER.COLUMNS.NAME} TEXT,
         ${DataBaseConstants.USER.COLUMNS.EMAIL} TEXT,
         ${DataBaseConstants.USER.COLUMNS.PASSWORD} TEXT
        );
    """

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTableUser)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("drop table if exists ${DataBaseConstants.USER.TABLE_NAME}")
        db?.execSQL(createTableUser)

    }
}