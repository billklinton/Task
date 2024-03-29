package com.example.task.repository

import android.content.Context
import android.database.Cursor
import com.example.task.constants.DataBaseConstants
import com.example.task.entities.PriorityEntity
import java.lang.Exception

class PriorityRepository private constructor(context: Context){
    private var mTaskDataBaseHelper: TaskDataBaseHelper = TaskDataBaseHelper(context)

    companion object {
        private var INSTANCE: PriorityRepository? = null

        fun getInstance(context: Context): PriorityRepository {
            if (INSTANCE == null) {
                INSTANCE = PriorityRepository(context)
            }
            return INSTANCE as PriorityRepository
        }
    }

    fun getList():MutableList<PriorityEntity>{

        val list = mutableListOf<PriorityEntity>()

        try {
            val cursor: Cursor
            val db = mTaskDataBaseHelper.readableDatabase

            cursor = db.rawQuery("select * from ${DataBaseConstants.PRIORITY.TABLE_NAME}", null)

            if(cursor.count > 0){
                while (cursor.moveToNext()){
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PRIORITY.COLUMNS.ID))
                    val description = cursor.getString(cursor.getColumnIndex(DataBaseConstants.PRIORITY.COLUMNS.DESCRIPTION))

                    list.add(PriorityEntity(id,description))
                }
            }
            cursor.close()

        }catch (e: Exception){
            return list
        }
        return list
    }
}