package com.dariopacule.mila.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dariopacule.mila.R
import com.dariopacule.mila.model.CondicionedConfig
import com.dariopacule.mila.model.Relatory_data
import java.util.*

class CondicionedConfigAdapter(
    private val context: Context,
    private val dataset: List<CondicionedConfig>
) :
    RecyclerView.Adapter<CondicionedConfigAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val sensorValue: TextView = view.findViewById(R.id.sensorConfig)
        val deleteAction: ImageButton = view.findViewById(R.id.deleteConfig)
        val levelValue: TextView = view.findViewById(R.id.levelConfig)
        val operationValue: TextView = view.findViewById(R.id.operationConfig)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.condicioned_recyclerdesig, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.sensorValue.text = item.sensorType
        holder.deleteAction.setOnClickListener {}
        holder.levelValue.text = item.level.toString()
    }

    override fun getItemCount() = dataset.size
}