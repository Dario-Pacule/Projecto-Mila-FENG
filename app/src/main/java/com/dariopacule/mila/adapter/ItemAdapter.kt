package com.dariopacule.mila.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dariopacule.mila.R
import com.dariopacule.mila.model.Relatory_data
import java.util.*

class ItemAdapter(private val context: Context, private val dataset: List<Relatory_data>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val iconRelatory: ImageView = view.findViewById(R.id.icon_relatory)
        val titleRelatory: TextView = view.findViewById(R.id.title_text_relatory)
        val dataRelatory: TextView = view.findViewById(R.id.data_text_relatory)
        val hourRelatory: TextView = view.findViewById(R.id.hora_text_relatory)
        val duractionRelatory: TextView = view.findViewById(R.id.duracao_text_relatory)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerdesign, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.iconRelatory.setImageResource(item.icon)
        holder.titleRelatory.text = item.operationType
        holder.dataRelatory.text = item.data
        holder.hourRelatory.text = item.hour
        holder.duractionRelatory.text = item.duraction
    }

    override fun getItemCount() = dataset.size
}