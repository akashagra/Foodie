package com.akashdeveloper.foodie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MealsItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_item)
        val intent = intent
        val transaction = this.getSupportFragmentManager().beginTransaction()
        transaction.add(R.id.container, MealsItemFragment.newInstance(intent.getIntExtra("FragmentId", 0)))
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
