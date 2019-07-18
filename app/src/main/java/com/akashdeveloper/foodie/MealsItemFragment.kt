package com.akashdeveloper.foodie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashdeveloper.foodie.ui.main.CatogeryAdapter
import com.akashdeveloper.foodie.ui.main.CatogeryResponse
import com.akashdeveloper.foodie.ui.main.MealsViewModel
import java.util.ArrayList

class MealsItemFragment : Fragment() {
    var categoryId : String? = null

    companion object {
        @JvmStatic
        fun newInstance(id: String): MealsItemFragment {
            val mealsItemFragment = MealsItemFragment()
            val args = Bundle()
            args.putString("CategoryTitle", id)
            mealsItemFragment.arguments = args
            return mealsItemFragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null) {
            categoryId = arguments?.getString("CategoryTitle")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.meals_item_screen, container, false)
        val mealsItemView : RecyclerView = v.findViewById(R.id.meals_item_view)
        mealsItemView.layoutManager = GridLayoutManager(context, 2)
        val mealsItemViewModel : MealsViewModel = ViewModelProviders.of(this).get(MealsViewModel::class.java!!)
        mealsItemViewModel.getItems(categoryId)?.observe(this,
            Observer<ArrayList<ItemResponse.Item>> { t ->
                if(t != null) {
                    val itemAdapter = ItemAdapter(t, object : ItemAdapter.ItemClickedListener {
                        override fun onItemClick(view: View, position: Int) {

                        }

                    })
                    mealsItemView.adapter = itemAdapter
                }
            })
        return v
    }

}




