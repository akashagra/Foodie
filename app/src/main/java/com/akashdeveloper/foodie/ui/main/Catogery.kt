package com.akashdeveloper.foodie.ui.main

import android.arch.lifecycle.LiveData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatogeryResponse {
    @SerializedName("catogeries")
    @Expose
    val catogeries: LiveData<List<Catogery>>? = null

    class Catogery {

        @SerializedName("strCategory")
        @Expose
        var title: String? = null
        @SerializedName("strCategoryThumb")
        @Expose
        var image: String? = null
    }
}