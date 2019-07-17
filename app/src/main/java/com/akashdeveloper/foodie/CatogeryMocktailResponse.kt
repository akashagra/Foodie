package com.akashdeveloper.foodie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatogeryMocktailResponse{
    @SerializedName("drinks")
    @Expose
    var categories: ArrayList<Catogery>? = null

    class Catogery {

        @SerializedName("strDrink")
        @Expose
        var title: String? = null
        @SerializedName("strDrinkThumb")
        @Expose
        var image: String? = null
    }
}