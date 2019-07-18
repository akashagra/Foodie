package com.akashdeveloper.foodie

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashdeveloper.foodie.ui.main.CatogeryResponse
import kotlinx.android.synthetic.main.catogery_adapter.view.*
import kotlinx.android.synthetic.main.item_adapter.view.*

class ItemAdapter( val itemList: ArrayList<ItemResponse.Item>, val mListener: ItemAdapter.ItemClickedListener) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    interface ItemClickedListener {
        fun onItemClick(view: View, position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(itemList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        fun bindItems(item: ItemResponse.Item) {
            itemView.item_image.setImageURI(Uri.parse(item.image))
            itemView.item_text.text = item.title
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val id = v?.getId()
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (id == R.id.item) {
                    if (v != null) {
                        mListener.onItemClick(v, position)
                    }
                }
            }
        }
    }

}
