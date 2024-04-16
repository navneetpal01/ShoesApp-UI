package com.example.shoesapp_ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoesapp_ui.mock.generateProducts
import com.example.shoesapp_ui.model.ProductUiModel
import com.example.shoesapp_ui.ui.theme.MediumText
import com.example.shoesapp_ui.ui.theme.ShoesAppUITheme
import com.example.shoesapp_ui.viewmodel.SharedViewModel


@Composable
fun HomeScreen(
    viewModel: SharedViewModel,
    navController: NavController
) {

    HomeContent(
        onProductClick = { product ->
            viewModel.selectedProduct(product)
            //Navigate to Detail Screen
        }
    )

}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onProductClick: (ProductUiModel) -> Unit
) {
    val productList by remember { mutableStateOf(generateProducts()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 20.dp)
    ){
        item { 
            Text(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .padding(start = 22.dp),
                text = "Bytesthetic",
                color = MediumText,
                fontWeight = FontWeight.Medium
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShoesAppUITheme {
        HomeContent(
            onProductClick = {

            }
        )
    }
}