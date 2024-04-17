package com.example.shoesapp_ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shoesapp_ui.component.CategoriesList
import com.example.shoesapp_ui.component.ProductHorizontalList
import com.example.shoesapp_ui.component.ProductSmallCard
import com.example.shoesapp_ui.mock.generateProducts
import com.example.shoesapp_ui.model.ProductUiModel
import com.example.shoesapp_ui.ui.theme.Accent
import com.example.shoesapp_ui.ui.theme.DarkText
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
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .padding(start = 22.dp),
                text = "Bytesthetic",
                fontSize = 42.sp,
                color = MediumText,
                fontWeight = FontWeight.Medium
            )
        }

        item {
            CategoriesList(
                modifier = Modifier
                    .padding(top = 28.dp)
            )
        }
        item {
            ProductHorizontalList(
                modifier = Modifier
                    .padding(top = 22.dp),
                productList = productList,
                onProductClick = { product ->
                    onProductClick(product)
                }
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 34.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Popular",
                    color = DarkText,
                    fontSize = 12.sp,
                )

                Text(
                    text = "See All",
                    color = Accent,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        items(productList.reversed()) { product ->
            ProductSmallCard(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(bottom = 16.dp),
                product = product,
                onProductClick = { product ->
                    onProductClick(product)
                },
                onAddToCartClick = {}
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