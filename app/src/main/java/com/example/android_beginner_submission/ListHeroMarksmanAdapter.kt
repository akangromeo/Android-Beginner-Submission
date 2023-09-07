package com.example.android_beginner_submission

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_beginner_submission.databinding.ItemRowBinding

class ListHeroMarksmanAdapter(private val listHeroMarksman: ArrayList<HeroMarksman>) :
    RecyclerView.Adapter<ListHeroMarksmanAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ItemRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHeroMarksman.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHeroMarksman[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvDesc.text = description
        holder.itemView.setOnClickListener {
            val intentDetails = Intent(holder.itemView.context, HeroDetails::class.java)
            intentDetails.putExtra(HeroDetails.key_heroMM, listHeroMarksman[position])
            holder.itemView.context.startActivity(intentDetails)
        }
    }

    class  ListViewHolder(var binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root){

    }
}

