package com.example.todo_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.databinding.CardDesignBinding
import com.example.todo_app.entity.Works
import com.example.todo_app.fragments.MainpageFragmentDirections
import com.example.todo_app.util.gecisYap
import com.example.todo_app.viewModel.MainpageFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class WorksAdapter(var mContext:Context,
                   var workList:List<Works>,
                   var viewModel: MainpageFragmentViewModel)
    : RecyclerView.Adapter<WorksAdapter.CardTasarimKeeper>() {

    inner class CardTasarimKeeper(binding:CardDesignBinding) : RecyclerView.ViewHolder(binding.root){
        var binding:CardDesignBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding:CardDesignBinding = DataBindingUtil.inflate(layoutInflater, com.example.todo_app.R.layout.card_design,parent, false)
        return CardTasarimKeeper(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimKeeper, position: Int) {
        val work1 = workList.get(position)
        val t = holder.binding
        t.workObject = work1

        t.textViewWork.text = "${work1.todo_work}"

        t.imageViewDeletePic.setOnClickListener {
            Snackbar.make(it, "Are you sure to delete ${work1.todo_work}  ?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    viewModel.delete(work1.todo_id)
                }.show()
        }

        t.rowCard.setOnClickListener {
            val gecis = MainpageFragmentDirections.detayGecis(work1)
            Navigation.gecisYap(it, gecis)
        }
    }

    override fun getItemCount(): Int {
        return  workList.size
    }
}