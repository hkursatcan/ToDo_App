package com.example.todo_app.room

import androidx.room.*
import com.example.todo_app.entity.Works

@Dao
interface WorksDao {
    @Query("SELECT * FROM todo_list")
    suspend fun allWorks(): List<Works>

    @Insert
    suspend fun workAdd(work: Works)

    @Update
    suspend fun workUpdate(work: Works)

    @Delete
    suspend fun workDelete(work: Works)

    @Query("SELECT * FROM todo_list WHERE todo_work like '%' || :searchWord || '%'")
    suspend fun workSearch(searchWord: String): List<Works>
}