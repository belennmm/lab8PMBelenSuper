package com.example.lab8pmbelensupermarket.navigation

public open class AppScreens (val route: String){
    object CategoriesScreen: AppScreens("first")
    object AddSupermarketItemScreen : AppScreens("two")
    object SupermarketItemListScreen : AppScreens("tird")
    object SupermarketScreen : AppScreens("four")
}