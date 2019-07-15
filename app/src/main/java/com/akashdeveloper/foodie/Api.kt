package com.akashdeveloper.foodie

import com.akashdeveloper.foodie.ui.main.CatogeryResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("categories.php")
    abstract fun getCatogeries(): Call<CatogeryResponse>
}