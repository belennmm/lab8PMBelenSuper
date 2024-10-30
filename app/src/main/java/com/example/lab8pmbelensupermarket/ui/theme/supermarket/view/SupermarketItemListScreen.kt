package com.uvg.laboratorio8supermarket.ui.supermarket.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import com.example.lab8pmbelensupermarket.networking.datac.SupermarketItem


@Composable
fun SupermarketItemListScreen(
    items: List<SupermarketItem>,
    navController: NavHostController
) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(items) { item ->
            SupermarketItemCard(item = item)
        }
    }
}

@Composable
fun SupermarketItemCard(item: SupermarketItem) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {

        Column(modifier = Modifier.padding(15.dp)) {

            Text(text = "Artículo: ${item.itemName}")


            Text(text = "Cantidad: ${item.quantity}")


            item.imagePath?.let { imagePath ->
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imagePath)
                        .crossfade(true)
                        .build()
                )

                Image(
                    painter = painter,
                    contentDescription = "Imagen",
                    modifier = Modifier
                        .size(145.dp)
                        .padding(7.dp),
                    contentScale = ContentScale.Crop
                )
            } ?: Text(text = "No existe imagen actual")
        }
    }
}
