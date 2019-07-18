package com.akashdeveloper.foodie.ui.main

import com.akashdeveloper.foodie.Api
import com.akashdeveloper.foodie.RetrofitInstance
import retrofit2.Call
import retrofit2.Response
import kotlin.collections.ArrayList
import android.arch.lifecycle.MutableLiveData
import com.akashdeveloper.foodie.CatogeryMocktailResponse
import retrofit2.Callback
class MealsRepository {
    fun getCatogeries(): MutableLiveData<ArrayList<CatogeryResponse.Catogery>> {
       val api = RetrofitInstance.retrofitInstanceMeals?.create(Api::class.java)
        val catogeries = MutableLiveData<ArrayList<CatogeryResponse.Catogery>>()
        if (api != null) {
            api.getCatogeries().enqueue(object : Callback<CatogeryResponse> {
                override fun onResponse(
                    call: Call<CatogeryResponse>,
                    response: Response<CatogeryResponse>
                ) {
                    if (response.isSuccessful()) {
                        catogeries.setValue(response.body()?.categories)
                    }
                }

                override fun onFailure(call: Call<CatogeryResponse>, t: Throwable) {
                    catogeries.setValue(null)
                }
            })
        }
        return catogeries
    }

    fun getMocktailCatogeries(): MutableLiveData<ArrayList<CatogeryMocktailResponse.Catogery>> {
        val api = RetrofitInstance.retrofitInstanceCocktails?.create(Api::class.java)
        val catogeries = MutableLiveData<ArrayList<CatogeryMocktailResponse.Catogery>>()
        if (api != null) {
            api.getMocktailCatogeries().enqueue(object : Callback<CatogeryMocktailResponse> {
                override fun onResponse(
                    call: Call<CatogeryMocktailResponse>,
                    response: Response<CatogeryMocktailResponse>
                ) {
                    if (response.isSuccessful()) {
                        catogeries.setValue(response.body()?.categories)
                    }
                }

                override fun onFailure(call: Call<CatogeryMocktailResponse>, t: Throwable) {
                    catogeries.setValue(null)
                }
            })
        }
        return catogeries
    }

    companion object {

        private var mealsRepository: MealsRepository? = null

        val instance: MealsRepository
            get() {
                if (mealsRepository == null) {
                    mealsRepository = MealsRepository()
                }
                return mealsRepository as MealsRepository
            }
    }
}
