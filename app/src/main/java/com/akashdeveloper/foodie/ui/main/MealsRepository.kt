package com.akashdeveloper.foodie.ui.main

import android.app.Application
import android.arch.lifecycle.LiveData
import com.akashdeveloper.foodie.Api
import com.akashdeveloper.foodie.RetrofitInstance
import retrofit2.Call
import retrofit2.Response
import kotlin.collections.ArrayList
import android.arch.lifecycle.MutableLiveData
import retrofit2.Callback


class MealsRepository {

    private val api: Api?

    init {
        api = RetrofitInstance.retrofitInstance?.create(Api::class.java)
    }

    fun getCatogeries(): MutableLiveData<CatogeryResponse> {
        val catogeries = MutableLiveData<CatogeryResponse>()
        if (api != null) {
            api.getCatogeries().enqueue(object : Callback<CatogeryResponse> {
                override fun onResponse(
                    call: Call<CatogeryResponse>,
                    response: Response<CatogeryResponse>
                ) {
                    if (response.isSuccessful()) {
                        catogeries.setValue(response.body())
                    }
                }

                override fun onFailure(call: Call<CatogeryResponse>, t: Throwable) {
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