package com.akashdeveloper.foodie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemResponse {
    @SerializedName("meals")
    @Expose
    var meals: ArrayList<ItemResponse.Item>? = null

    class Item {
        @SerializedName("strMeal")
        @Expose
        var title : String? = null

        @SerializedName("strMealThumb")
        @Expose
        var image : String? = null

        @SerializedName("idMeal")
        @Expose
        var idMeal : Int? = 0
    }
}
