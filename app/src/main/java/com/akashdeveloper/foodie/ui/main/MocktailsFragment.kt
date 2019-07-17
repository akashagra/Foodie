package com.akashdeveloper.foodie.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashdeveloper.foodie.CatogeryMocktailResponse
import com.akashdeveloper.foodie.R

class MocktailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.mocktails_screen, container, false)
        val mocktailsView : RecyclerView = v.findViewById(R.id.mocktails_view)
        mocktailsView.layoutManager = GridLayoutManager(context, 2)
        val mocktailsViewModel : MealsViewModel = ViewModelProviders.of(this).get(MealsViewModel::class.java!!)
        mocktailsViewModel.getMocktailsCatogeries()?.observe(this,
            Observer<ArrayList<CatogeryMocktailResponse.Catogery>> { t ->
                if(t != null) {
                    val catogeryMocktailsAdapter = CatogeryMocktailsAdapter(t)
                    mocktailsView.adapter = catogeryMocktailsAdapter
                }
            })
        return v
    }

}
