@file:Suppress("DEPRECATION")

package com.example.todo_app.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_app.R
import com.example.todo_app.adapter.WorksAdapter
import com.example.todo_app.databinding.FragmentMainpageBinding
import com.example.todo_app.util.gecisYap
import com.example.todo_app.viewModel.MainpageFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainpageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentMainpageBinding
    private lateinit var viewModel: MainpageFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mainpage,container, false)
        binding.mainpageFragment = this
        binding.mainpageToolbarHeader = "To Do Works"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainpage)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.workList.observe(viewLifecycleOwner) {
            val adapter = WorksAdapter(requireContext(), it, viewModel)
            binding.worksAdapter = adapter
        }

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.recordGecis)
        }

        return binding.root
    }

    fun fabClick(view:View){
        Navigation.gecisYap(view, R.id.recordGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:MainpageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_search)
        val searcView = item.actionView as SearchView
        searcView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.worksUpload()
    }
}