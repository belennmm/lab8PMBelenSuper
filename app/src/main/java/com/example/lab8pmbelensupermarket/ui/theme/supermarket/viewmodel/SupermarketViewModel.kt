package com.uvg.laboratorio8supermarket.ui.supermarket.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab8pmbelensupermarket.dataBase.SupermarketItemDao
import com.example.lab8pmbelensupermarket.networking.datac.SupermarketItem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SupermarketViewModel(private val dao: SupermarketItemDao) : ViewModel() {

    var supermarketItems = mutableStateOf<List<SupermarketItem>>(emptyList())
        private set

    init {
        loadItems()
    }

    fun addItem(name: String, quantity: Int, imagePath: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val newItem = SupermarketItem(
                itemName = name,
                quantity = quantity,
                imagePath = imagePath
            )
            dao.insertItem(newItem)
            loadItems()
        }
    }

    private fun loadItems() {
        viewModelScope.launch(Dispatchers.IO) {
            val items = dao.getAllItems<Any?>()
            supermarketItems.value = items
        }
    }
}
