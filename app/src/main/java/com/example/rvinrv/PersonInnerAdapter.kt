package com.example.rvinrv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rvinrv.databinding.ItemPersonBinding

class PersonInnerAdapter: RecyclerView.Adapter<PersonInnerAdapter.PersonViewHolder>(){
    var models = listOf<Person>()
        @SuppressLint("notifyDataSetChanged()")
        set(value){
            field = value
            notifyDataSetChanged()
        }
    inner class PersonViewHolder(private val binding: ItemPersonBinding): ViewHolder(binding.root){
        fun bind(person: Person){
            binding.apply {
                imageProgramm.setBackgroundResource(R.drawable.video_image)
                imageProgrammMini.setImageResource(person.Imagem_mini)
                textProgramm.text = person.name
            }
        }
    }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent,false)
                val binding = ItemPersonBinding.bind(view)
                return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(models[position])
    }
}