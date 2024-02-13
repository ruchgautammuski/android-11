package com.ruchi


import Card
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class GridAdapter(var context: Context, var cardsList : List<Card>): BaseAdapter(){
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Any {
        return cardsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View = View.inflate(context, R.layout.grid, null)

        val image : ImageView = view.findViewById(R.id.grid_item)
        image.setImageResource(R.drawable.img2)

        return view
    }
}
