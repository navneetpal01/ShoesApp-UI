package com.example.shoesapp_ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoesapp_ui.mock.generateCategories
import com.example.shoesapp_ui.ui.theme.ShoesAppUITheme


@Composable
fun CategoriesList(
    modifier : Modifier = Modifier
){

    val categoryList by remember { mutableStateOf(generateCategories()) }
    var selectedCategory by remember { mutableStateOf("Sneakers") }

    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(categoryList){category ->

            
        }
    }
}

@Composable
fun CategoryItem(
    modifier : Modifier = Modifier,
    name : String,
    isSelected : Boolean
){
    
}


@Preview(showBackground = true)
@Composable
fun CategoryListPreview(){
    ShoesAppUITheme {
        CategoriesList(
            modifier = Modifier
                .padding(6.dp)
        )
    }
}