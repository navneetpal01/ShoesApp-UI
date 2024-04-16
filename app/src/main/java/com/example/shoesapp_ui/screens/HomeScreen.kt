package com.example.shoesapp_ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.shoesapp_ui.model.ProductUiModel
import com.example.shoesapp_ui.ui.theme.ShoesAppUITheme
import com.example.shoesapp_ui.viewmodel.SharedViewModel


@Composable
fun HomeScreen(
    viewModel : SharedViewModel,
    navController: NavController
){

    HomeContent(
        onProductClick = {product ->
            viewModel.selectedProduct(product)
            //Navigate to Detail Screen
        }
    )

}

@Composable
fun HomeContent(
    modifier : Modifier = Modifier,
    onProductClick : (ProductUiModel) -> Unit
){
    val productList by remember { mutableStateOf() }
}



@Preview
@Composable
fun HomeScreenPreview(){
    ShoesAppUITheme {
        HomeContent(
            onProductClick = {

            }
        )
    }
}