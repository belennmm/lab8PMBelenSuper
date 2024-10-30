package com.example.lab8pmbelensupermarket.networking


import com.example.lab8pmbelensupermarket.networking.datac.CategoriesDC
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealWebService {
    private var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMealsCategories():CategoriesDC{
        return api.getCategories()
    }
}