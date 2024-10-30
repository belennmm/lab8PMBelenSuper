package com.example.lab8pmbelensupermarket.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab8pmbelensupermarket.networking.datac.SupermarketItem
import java.util.Locale


@Database(entities = [Locale.Category::class, SupermarketItem::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // relacionar con item
    abstract fun categoryDao(): CategoryDao
    abstract fun supermarketItemDao(): SupermarketItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "meal_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}