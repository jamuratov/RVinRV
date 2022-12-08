package com.example.rvinrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rvinrv.databinding.ItemPersonBinding
import com.example.rvinrv.databinding.ItemRvBinding

class RVAdapter: RecyclerView.Adapter<RVAdapter.RVViewHolder>() {

    inner class RVViewHolder(private val binding: ItemRvBinding): ViewHolder(binding.root){
        fun bind(rvItem: RVItem) {
            val personInnerAdapter = PersonInnerAdapter()
            binding.innerRecyclerView.adapter = personInnerAdapter
            binding.innerRecyclerView.addItemDecoration(
                DividerItemDecoration(itemView.context, DividerItemDecoration.HORIZONTAL)
            )

            personInnerAdapter.models = rvItem.items
        }
    }

    var models = listOf<RVItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        val binding = ItemRvBinding.bind(view)
        return RVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.bind(models[position])
    }
}