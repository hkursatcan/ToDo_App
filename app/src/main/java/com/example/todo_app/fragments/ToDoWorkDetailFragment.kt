package com.example.todo_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todo_app.databinding.FragmentWorkDetailBinding
import com.example.todo_app.viewmodel.ToDoWorkDetailViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoWorkDetailFragment : Fragment() {
    private lateinit var binding: FragmentWorkDetailBinding
    private lateinit var viewModel:ToDoWorkDetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, com.example.todo_app.R.layout.fragment_work_detail,container, false)
        binding.workDetailFragment = this
        binding.workDetailToolbarHeader = "Work Detail"

        val bundle:ToDoWorkDetailFragmentArgs by navArgs()
        val gelenWork = bundle.toDoWork
        binding.workObject = gelenWork

        binding.ToDoWorkDetailText.setText(gelenWork.todo_work)

        return binding.root
    }

    fun buttonUpdateClick(todo_id:Int, todo_work:String) {
        viewModel.update(todo_id, todo_work)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ToDoWorkDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

}