package com.example.lab8pmbelensupermarket.networking

import com.example.lab8pmbelensupermarket.networking.datac.CategoriesDC
import retrofit2.http.GET

interface MealsApi {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesDC

}
