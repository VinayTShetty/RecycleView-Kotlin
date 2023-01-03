package com.example.recycleviewkotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewkotlin.ItemsViewModel
import com.example.recycleviewkotlin.R
import java.util.*

class MyRecycleViewAdapter(
                           val mlist: ArrayList<ItemsViewModel>,
                           val myItemClickListner: MyItemClickListner
                           ) :
    RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_design, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemsViewModel = mlist[position]
        holder.imageView.setImageResource(itemsViewModel.image)
        holder.description.text = itemsViewModel.text
        holder.count.text = itemsViewModel.count.toString()
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

   inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val description: TextView = itemView.findViewById(R.id.textView_name)
        val count: TextView = itemView.findViewById(R.id.textView_count)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val poisition=adapterPosition
            myItemClickListner.myItemClicked(poisition )
        }
    }

    interface MyItemClickListner{
        fun myItemClicked(poisition:Int)
    }
}