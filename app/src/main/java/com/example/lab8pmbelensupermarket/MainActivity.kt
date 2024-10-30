package com.example.lab8pmbelensupermarket

import SupermarketViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab8pmbelensupermarket.ui.theme.Lab8PMBelenSuperMarketTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import com.example.lab8pmbelensupermarket.dataBase.AppDatabase
import com.example.lab8pmbelensupermarket.navigation.AppNavigation
import com.uvg.laboratorio8supermarket.ui.supermarket.viewmodel.SupermarketViewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtener la instancia de la base de datos
        val database = AppDatabase.getDatabase(this)
        val supermarketDao = database.supermarketItemDao()

        // Crear la fábrica de ViewModel
        val viewModelFactory = SupermarketViewModelFactory(supermarketDao)

        // Crear la instancia del ViewModel
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SupermarketViewModel::class.java)

        setContent {
            Lab8PMBelenSuperMarketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}