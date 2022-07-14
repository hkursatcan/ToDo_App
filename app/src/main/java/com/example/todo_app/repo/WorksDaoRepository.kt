package com.example.todo_app.repo

import androidx.lifecycle.MutableLiveData
import com.example.todo_app.entity.Works
import com.example.todo_app.room.WorksDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorksDaoRepository (var idao:WorksDao) {
    var workList: MutableLiveData<List<Works>>

    init {
        workList = MutableLiveData()
    }

    fun workRecord(todo_work:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            idao.workAdd(Works(0, todo_work ))
        }
    }

    fun workUpdate(todo_id:Int, todo_work: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedWorks = Works(todo_id, todo_work )
            idao.workUpdate(updatedWorks)
        }
    }

    fun workSearch(searchWord:String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            workList.value = idao.workSearch(searchWord)
        }
    }

    fun workDelete(todo_id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedWork = Works(todo_id, "")
            idao.workDelete(deletedWork)
            allWorks()
        }
    }

    fun allWorks() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            workList.value = idao.allWorks()
        }
    }

    fun worksGet() : MutableLiveData<List<Works>> {
        return workList
    }
}