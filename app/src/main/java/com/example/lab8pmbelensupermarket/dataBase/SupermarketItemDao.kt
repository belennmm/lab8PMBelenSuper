package com.example.lab8pmbelensupermarket.dataBase

import androidx.room.*
import com.example.lab8pmbelensupermarket.networking.datac.SupermarketItem


@Dao
interface SupermarketItemDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)    // nuevo
    suspend fun insertItem(item: SupermarketItem)


    @Update
    suspend fun updateItem(item: SupermarketItem) // actialización

    @Query("UPDATE supermarket_items SET imagePath = :imagePath WHERE id = :itemId")
    suspend fun updateImagePath(itemId: Int, imagePath: String)


    @Delete
    suspend fun <SupermarketItem> deleteItem(item: SupermarketItem) // eliminación

    @Query("SELECT * FROM supermarket_items")
    suspend fun <SupermarketItem> getAllItems(): List<SupermarketItem> // de la dataBase


    @Query("SELECT * FROM supermarket_items WHERE id = :itemId")
    suspend fun getItemById(itemId: Int): SupermarketItem? // objeto por el ID
}