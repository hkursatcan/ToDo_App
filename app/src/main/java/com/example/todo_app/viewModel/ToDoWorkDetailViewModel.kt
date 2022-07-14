package com.example.todo_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todo_app.repo.WorksDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoWorkDetailViewModel @Inject constructor(var irepo:WorksDaoRepository): ViewModel() {

    fun update(todo_id:Int, todo_work:String) {
        irepo.workUpdate(todo_id , todo_work )
    }
}