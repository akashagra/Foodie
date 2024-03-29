package com.akashdeveloper.foodie.ui.main

import android.app.Application
import android.arch.lifecycle.*
import com.akashdeveloper.foodie.CatogeryMocktailResponse
import com.akashdeveloper.foodie.ItemResponse

class MealsViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: MealsRepository

    init {
        mRepository = MealsRepository()
    }

    fun getCatogeries(): MutableLiveData<ArrayList<CatogeryResponse.Catogery>> {
        return mRepository.getCatogeries()
    }

    fun getMocktailsCatogeries(): MutableLiveData<ArrayList<CatogeryMocktailResponse.Catogery>> {
        return mRepository.getMocktailCatogeries()
    }

    fun getItems(id: String?) : MutableLiveData<ArrayList<ItemResponse.Item>> {
        return mRepository.getItem(id)
    }
}
