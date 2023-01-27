package com.example.withmehome

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewBinding


class RecyclerItemAdapter(var items: List<Userdata>) : RecyclerView.Adapter<RecyclerItemAdapter.ViewHolder>() {

    private lateinit var itemBinding: ItemViewBinding

    inner class ViewHolder(private val itemBinding: ItemViewBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: Userdata){
            itemBinding.title.text = data.title
            itemBinding.name.text = data.name
            itemBinding.date.text = data.date
            itemBinding.like.text = data.like
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(items[position])
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun setData(data: List<Userdata>){
        items = data
        notifyDataSetChanged()
    }

}
