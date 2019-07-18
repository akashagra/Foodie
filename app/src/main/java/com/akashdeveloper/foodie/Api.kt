package com.akashdeveloper.foodie

import com.akashdeveloper.foodie.ui.main.CatogeryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("categories.php")
    fun getCatogeries(): Call<CatogeryResponse>

    @GET("filter.php?c=Cocktail")
    fun getMocktailCatogeries() : Call<CatogeryMocktailResponse>

    @GET("filter.php")
    fun getItem(@Query("c") query : String?) : Call<ItemResponse>
}