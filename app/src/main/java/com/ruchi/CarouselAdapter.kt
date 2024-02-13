package com.ruchi



import Card
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CarouselAdaptor(var cardsList: List<Card>): RecyclerView.Adapter<CarouselAdaptor.itemViewHolder>(){

    inner class itemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.carousel_item, parent, false)
        return itemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.itemView.apply {
            val image: ImageView = findViewById(R.id.carousel_image_view)
            image.setImageResource(R.drawable.img1)
        }
    }
}