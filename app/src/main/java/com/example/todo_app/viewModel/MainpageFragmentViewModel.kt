package com.example.todo_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_app.entity.Works
import com.example.todo_app.repo.WorksDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainpageFragmentViewModel @Inject constructor(var irepo:WorksDaoRepository): ViewModel() {
    var workList = MutableLiveData<List<Works>>()

    init {
        worksUpload()
        workList = irepo.worksGet()
    }

    fun search(searchWord:String) {
        irepo.workSearch(searchWord)
    }

    fun delete(todo_id:Int) {
        irepo.workDelete(todo_id)
    }

    fun worksUpload() {
        irepo.allWorks()
    }
}