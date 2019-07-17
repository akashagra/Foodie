package com.akashdeveloper.foodie.ui.main

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashdeveloper.foodie.CatogeryMocktailResponse
import com.akashdeveloper.foodie.R
import kotlinx.android.synthetic.main.catogery_adapter.view.*

class CatogeryMocktailsAdapter(val categoryMocktailList: ArrayList<CatogeryMocktailResponse.Catogery>) : RecyclerView.Adapter<CatogeryMocktailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.catogery_mocktail_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return categoryMocktailList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categoryMocktailList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(catogery : CatogeryMocktailResponse.Catogery) {
            itemView.region_image.setImageURI(Uri.parse(catogery.image))
            itemView.region_text.text = catogery.title
        }
    }
}
