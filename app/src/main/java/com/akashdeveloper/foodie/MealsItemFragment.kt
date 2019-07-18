package com.akashdeveloper.foodie

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList

class MealsItemFragment : Fragment() {
    var categoryId : Int? = 0

    companion object {
        @JvmStatic
        fun newInstance(id: Int): MealsItemFragment {
            val mealsItemFragment = MealsItemFragment()
            val args = Bundle()
            args.putInt("FragmentId", id)
            return mealsItemFragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null) {
            categoryId = arguments?.getInt("FragmentId")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.meals_item_screen, container, false)
        return v
    }

}




