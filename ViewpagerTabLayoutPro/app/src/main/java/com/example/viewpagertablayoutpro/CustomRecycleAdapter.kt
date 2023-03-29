package com.example.viewpagertablayoutpro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertablayoutpro.databinding.ItemViewBinding

class CustomRecycleAdapter(val dataList : MutableList<DataList>) : RecyclerView.Adapter<CustomRecycleAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding : ItemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }
    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding
        //val binding : ItemViewBinding = (holder as CustomViewHolder).binding
        binding.tvName.text = dataList.get(position).tvName
        binding.tvAge.text = dataList.get(position).tvAge
        binding.tvEMail.text = dataList.get(position).tvEmail
        binding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${binding.tvName.text.toString()}", Toast.LENGTH_SHORT).show()
        }

        binding.root.setOnLongClickListener {
            dataList.removeAt(position)
            Toast.makeText(binding.root.context, "${binding.tvName.text.toString()} 삭제완료", Toast.LENGTH_SHORT).show()
            notifyDataSetChanged()
            true
        }
    }
    class CustomViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)
}