package com.akashdeveloper.foodie.ui.main

import android.app.Application
import android.arch.lifecycle.*

class MealsViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: MealsRepository

    val allCatogery: MutableLiveData<CatogeryResponse>

    init {
        mRepository = MealsRepository()
        allCatogery = mRepository.getCatogeries()
    }

}
