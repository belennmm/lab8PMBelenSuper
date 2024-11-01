package com.example.lab8pmbelensupermarket.navigation

import CategoriesScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab8pmbelensupermarket.ui.theme.supermarket.view.SupermarketScreen
import com.uvg.laboratorio8supermarket.ui.supermarket.view.AddSupermarketItemScreen
import com.uvg.laboratorio8supermarket.ui.supermarket.view.SupermarketItemListScreen
import com.uvg.laboratorio8supermarket.ui.supermarket.viewmodel.SupermarketViewModel

@Composable
fun AppNavigation(viewModel: SupermarketViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = AppScreens.CategoriesScreen.route) {
        composable(route = AppScreens.CategoriesScreen.route) {
            CategoriesScreen(navController = navController)
        }

        composable(route = AppScreens.SupermarketScreen.route) {
            SupermarketScreen(viewModel = viewModel, context = context, navController = navController)
        }


        composable(route = AppScreens.AddSupermarketItemScreen.route) {
            AddSupermarketItemScreen( // agregar
                context = context,
                viewModel = viewModel,
                navController = navController,
                onItemAdded = {
                    navController.navigate(AppScreens.SupermarketItemListScreen.route)
                }
            )
        }


        composable(route = AppScreens.SupermarketItemListScreen.route) {
            SupermarketItemListScreen(items = viewModel.supermarketItems.value, navController = navController)
            // lista de objetos
        }
    }
}
