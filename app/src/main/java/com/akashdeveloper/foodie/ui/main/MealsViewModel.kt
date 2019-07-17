package com.akashdeveloper.foodie.ui.main

import android.app.Application
import android.arch.lifecycle.*

class MealsViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: MealsRepository

    var allCatogery: MutableLiveData<ArrayList<CatogeryResponse.Catogery>>? = null

    init {
        mRepository = MealsRepository()
        allCatogery = mRepository.getCatogeries()
    }

}
