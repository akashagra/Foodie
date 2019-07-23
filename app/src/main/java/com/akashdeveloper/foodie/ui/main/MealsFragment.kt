package com.akashdeveloper.foodie.ui.main

import android.app.ActivityOptions
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.SharedElementCallback
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashdeveloper.foodie.MealsItemActivity
import com.akashdeveloper.foodie.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.meals_screen.*
import kotlinx.android.synthetic.main.meals_screen.view.*
import java.util.*
import kotlin.collections.ArrayList
import android.app.SharedElementCallback as SharedElementCallback1

class MealsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.meals_screen, container, false)
//        val mealsView : RecyclerView = v.findViewById(R.id.meals_view)
        v.meals_view.layoutManager = GridLayoutManager(context, 2)
        val mealsViewModel : MealsViewModel = ViewModelProviders.of(this).get(MealsViewModel::class.java!!)
        mealsViewModel.getCatogeries()?.observe(this,
            Observer<ArrayList<CatogeryResponse.Catogery>> { t ->
                if(t != null) {
                    val catogeryAdapter = CatogeryAdapter(t, object : CatogeryAdapter.CategoryClickedListener {
                        override fun onItemClick(view: View, position: Int) {
                            val intent = Intent(activity, MealsItemActivity::class.java)
                            intent.putExtra("CategoryTitle",t.get(position).title)
                            intent.putExtra("CategoryImage",t.get(position).image)
                            activity?.let {
                                ActivityCompat.setExitSharedElementCallback(it, object : SharedElementCallback() {
                                    override fun onSharedElementEnd(
                                        sharedElementNames: List<String>,
                                        sharedElements: List<View>,
                                        sharedElementSnapshots: List<View>
                                    ) {

                                        super.onSharedElementEnd(
                                            sharedElementNames, sharedElements,
                                            sharedElementSnapshots
                                        )

                                        for (view in sharedElements) {
                                            view.visibility = View.VISIBLE
                                        }
                                    }
                                })
                            }

                            var bundle = ActivityOptions
                                .makeSceneTransitionAnimation(
                                    activity,
                                    view.findViewById(R.id.category_image),
                                    "cover_image_transition"
                                ).toBundle()

                            startActivity(intent, bundle)
                        }

                    })
                    v.meals_view.adapter = catogeryAdapter
                }
            })
        return v
    }
}