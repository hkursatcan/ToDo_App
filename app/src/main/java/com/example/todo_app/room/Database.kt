package com.example.todo_app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_app.entity.Works


@Database(entities = [Works::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getWorksDao() : WorksDao
}