package com.fuad.linktreeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fuad.linktreeapp.R
import com.fuad.linktreeapp.model.LinktreeModel

class LinkAdapter(val item: List<LinktreeModel>, val listener: AdapterListener)
    :RecyclerView.Adapter<LinkAdapter.ViewHolder>(){

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val image = view.findViewById<ImageView>(R.id.image)
            val title = view.findViewById<TextView>(R.id.title)
        }

    interface AdapterListener{
        fun onClick(linktree: LinktreeModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_link, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = item[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title

        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }
}