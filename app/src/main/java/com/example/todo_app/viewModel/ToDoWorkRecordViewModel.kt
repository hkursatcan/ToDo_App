package com.example.todo_app.viewModel

import androidx.lifecycle.ViewModel
import com.example.todo_app.repo.WorksDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoWorkRecordViewModel @Inject constructor(var irepo:WorksDaoRepository): ViewModel() {
    fun record(todo_work:String){
        irepo.workRecord(todo_work)
    }
}