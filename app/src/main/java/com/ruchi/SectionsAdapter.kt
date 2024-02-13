package com.ruchi

import Card
import Section
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SectionsAdapter(var sectionsList: List<Section>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class Section1ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cardImage: ImageView = itemView.findViewById(R.id.card_item)

        fun bind(section: Section){
            cardImage.setImageResource(R.drawable.img)
        }
    }

    inner class Section2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val carouselRV : RecyclerView = itemView.findViewById(R.id.carouselRV)

        fun bind(section: Section){
            val card = Card()
            val adapter = CarouselAdaptor(listOf(card, card, card, card, card, card))
            carouselRV.adapter = adapter
            carouselRV.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    inner class Section3ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val grid : GridView = itemView.findViewById(R.id.grid)

        fun bind(section: Section){
            val card = Card()
            val adapter = GridAdapter(itemView.context, listOf(card, card, card, card, card))
            grid.adapter = adapter
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            1 -> {
                val view = inflater.inflate(R.layout.only_card, parent, false)
                Section1ViewHolder(view)
            }
            2 -> {
                val view = inflater.inflate(R.layout.carousel, parent, false)
                Section2ViewHolder(view)
            }
            3 -> {
                val view = inflater.inflate(R.layout.gridsection, parent, false)
                Section3ViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return sectionsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val section = sectionsList[position]
        when(holder.itemViewType){
            1 -> {
                val viewHolder = holder as Section1ViewHolder
                viewHolder.bind(section)
            }
            2 -> {
                val viewHolder = holder as Section2ViewHolder
                viewHolder.bind(section)
            }
            3 -> {
                val viewHolder = holder as Section3ViewHolder
                viewHolder.bind(section)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return sectionsList[position].type
    }

}