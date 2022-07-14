package com.example.todo_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todo_app.R
import com.example.todo_app.databinding.FragmentWorkRecordBinding
import com.example.todo_app.viewModel.ToDoWorkRecordViewModel


import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ToDoWorkRecordFragment : Fragment() {
    private lateinit var binding: FragmentWorkRecordBinding
    private lateinit var viewModel:ToDoWorkRecordViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_work_record,container, false)

        binding.workRecordFragment = this
        binding.workRecordToolbarHeader = "Work Add"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ToDoWorkRecordViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonRecordClick(todo_work:String){
        viewModel.record(todo_work)
    }
}