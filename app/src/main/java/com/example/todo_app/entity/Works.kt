package com.example.todo_app.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity (tableName = "todo_list")
class Works (@PrimaryKey(autoGenerate = true)
            @ColumnInfo(name = "todo_id") @NotNull var todo_id:Int,
            @ColumnInfo(name = "todo_work") @NotNull var todo_work:String) : Serializable {
}