package com.akashdeveloper.foodie.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashdeveloper.foodie.R
import kotlinx.android.synthetic.*

class MealsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.meals_screen, container, false)
        val mealsView : RecyclerView = v.findViewById(R.id.meals_view)
        val regionList : ArrayList<CatogeryResponse.Catogery> = ArrayList()
        val catogeryAdapter = CatogeryAdapter(regionList)
        mealsView.adapter = catogeryAdapter
        mealsView.layoutManager = GridLayoutManager(context, 2)
        return v
    }
}