package com.example.shoesapp_ui

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shoesapp_ui.model.ProductUiModel
import com.example.shoesapp_ui.screens.ProductDetailsContent
import com.example.shoesapp_ui.ui.theme.Product_1
import com.example.shoesapp_ui.ui.theme.Product_2
import com.example.shoesapp_ui.ui.theme.Product_3
import com.example.shoesapp_ui.ui.theme.Product_4
import com.example.shoesapp_ui.ui.theme.Product_5
import com.example.shoesapp_ui.ui.theme.Product_6
import com.example.shoesapp_ui.ui.theme.Product_7
import com.example.shoesapp_ui.ui.theme.Product_8


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}