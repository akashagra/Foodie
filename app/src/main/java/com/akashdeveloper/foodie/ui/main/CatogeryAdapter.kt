package com.akashdeveloper.foodie.ui.main

import android.graphics.Region
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashdeveloper.foodie.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.catogery_adapter.view.*

class CatogeryAdapter(val catogerylist : ArrayList<CatogeryResponse.Catogery>): RecyclerView.Adapter<CatogeryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.catogery_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return catogerylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(catogerylist[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(catogery : CatogeryResponse.Catogery) {
            itemView.region_image.controller
            itemView.region_image.setImageURI(Uri.parse(catogery.image))
            itemView.region_text.text = catogery.title
        }
    }
}
