package com.example.shoesapp_ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoesapp_ui.R
import com.example.shoesapp_ui.model.ProductUiModel
import com.example.shoesapp_ui.ui.theme.Product_1

@Composable
fun ProductBigCard(
    modifier: Modifier = Modifier,
    product: ProductUiModel,
    onProductClick: (ProductUiModel) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFavourite by remember { mutableStateOf(false) }
    val annotationStr by remember {
        mutableStateOf(
            buildAnnotatedString {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("$${product.oldPrice}")
                }
            }
        )
    }
    Box(
        modifier = modifier
            .clickable(
                onClick = { onProductClick(product) },
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = true)
            )
            .size(168.dp, 210.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.3f)
                .background(color = product.color,shape = RoundedCornerShape(22.dp))
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProductBigCardPreview() {
    ProductBigCard(
        modifier = Modifier
            .padding(20.dp),
        product = ProductUiModel(
            imageResource = R.drawable.s_1,
            color = Product_1,
            name = "SA",
            price = 128.99f,
            oldPrice = 168.99f
        ),
        onProductClick = {}
    )
}