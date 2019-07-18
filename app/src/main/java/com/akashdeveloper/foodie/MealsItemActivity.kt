package com.akashdeveloper.foodie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MealsItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_item)
        val intent = intent
        val transaction = this.getSupportFragmentManager().beginTransaction()
        if(intent.getStringExtra("CategoryTitle") != null) {
            transaction.add(R.id.container, MealsItemFragment.newInstance(intent.getStringExtra("CategoryTitle"), intent.getStringExtra("CategoryImage")))
        }
        transaction.commit()
    }
}
