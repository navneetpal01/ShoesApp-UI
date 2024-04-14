package com.example.shoesapp_ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoesapp_ui.model.ProductUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SharedViewModel : ViewModel() {
    private val _selectedProduct = MutableStateFlow<ProductUiModel?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()


    fun selectedProduct(product : ProductUiModel){
        viewModelScope.launch {
            _selectedProduct.value = product
        }
    }

}