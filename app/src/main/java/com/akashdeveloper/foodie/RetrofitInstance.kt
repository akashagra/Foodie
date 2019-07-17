package com.akashdeveloper.foodie

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit: Retrofit? = null
    private var retrofitCocktail : Retrofit? = null
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    private val BASE2_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    val retrofitInstanceMeals: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    val retrofitInstanceCocktails : Retrofit?
    get() {
        if (retrofitCocktail == null) {
            retrofitCocktail = retrofit2.Retrofit.Builder()
                .baseUrl(BASE2_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitCocktail
    }
}
