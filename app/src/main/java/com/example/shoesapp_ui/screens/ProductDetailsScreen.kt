package com.example.shoesapp_ui.screens

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shoesapp_ui.R
import com.example.shoesapp_ui.model.ProductUiModel
import com.example.shoesapp_ui.ui.theme.Accent
import com.example.shoesapp_ui.ui.theme.Alternative_1
import com.example.shoesapp_ui.ui.theme.Alternative_2
import com.example.shoesapp_ui.ui.theme.Background
import com.example.shoesapp_ui.ui.theme.Border
import com.example.shoesapp_ui.ui.theme.DarkText
import com.example.shoesapp_ui.ui.theme.Favorite
import com.example.shoesapp_ui.ui.theme.IconTint
import com.example.shoesapp_ui.ui.theme.LightText
import com.example.shoesapp_ui.ui.theme.MediumText
import com.example.shoesapp_ui.ui.theme.Primary
import com.example.shoesapp_ui.ui.theme.Product_1
import com.example.shoesapp_ui.ui.theme.RegularText
import com.example.shoesapp_ui.ui.theme.Shadow
import com.example.shoesapp_ui.ui.theme.ShoesAppUITheme
import com.example.shoesapp_ui.ui.theme.Star
import com.example.shoesapp_ui.utils.Constants.DURATION
import com.example.shoesapp_ui.utils.Constants.SIZE_38
import com.example.shoesapp_ui.utils.Constants.SIZE_39
import com.example.shoesapp_ui.utils.Constants.SIZE_40
import com.example.shoesapp_ui.utils.Constants.SIZE_41
import com.example.shoesapp_ui.viewmodel.SharedViewModel
import kotlinx.coroutines.delay


@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: SharedViewModel,
    navController: NavController
) {

    val product by viewModel.selectedProduct.collectAsState()


    product?.let {
        ProductDetailsContent(
            modifier = modifier,
            product = it,
            goBackClick = {
                navController.popBackStack()
            }
        )
    }


}

@Composable
fun ProductDetailsContent(
    modifier: Modifier = Modifier,
    product: ProductUiModel,
    goBackClick: () -> Unit
) {

    var selectedSize by remember { mutableStateOf(SIZE_38) }
    var isFavourite by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf(product.color) }


    var xOffset by remember { mutableStateOf(800.dp) }
    var yOffset by remember { mutableStateOf(800.dp) }
    var buttonScale by remember { mutableFloatStateOf(0f) }
    var iconScale by remember { mutableFloatStateOf(0f) }
    var sneakerScale by remember { mutableFloatStateOf(0.6f) }
    var sneakerRotate by remember { mutableFloatStateOf(-60f) }

    val animatedXOffset = animateDpAsState(
        targetValue = xOffset,
        label = "",
        animationSpec = tween(durationMillis = DURATION, easing = FastOutLinearInEasing)
    )
    val animatedYOffset = animateDpAsState(
        targetValue = yOffset,
        label = "",
        animationSpec = tween(durationMillis = DURATION, easing = FastOutLinearInEasing)
    )
    val animatedButtonScale = animateFloatAsState(
        targetValue = buttonScale,
        label = "",
        animationSpec = tween(easing = FastOutLinearInEasing)
    )
    val animatedIconScale = animateFloatAsState(
        targetValue = iconScale,
        label = "",
        animationSpec = tween(easing = FastOutLinearInEasing)
    )
    val animatedSneakerScale = animateFloatAsState(
        targetValue = sneakerScale,
        label = "",
        animationSpec = tween(easing = FastOutLinearInEasing)
    )
    val animatedSneakerRotate = animateFloatAsState(
        targetValue = sneakerRotate,
        label = "",
        animationSpec = tween(easing = FastOutLinearInEasing)
    )

    LaunchedEffect(true) {
        delay(150)
        xOffset = 140.dp
        yOffset = -130.dp
        sneakerScale = 1f
        sneakerRotate = -30f
        delay(400)
        iconScale = 1f
        delay(100)
        buttonScale = 1f

    }


    Box(
        modifier = modifier
            .background(Background)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset(x = animatedXOffset.value, y = animatedYOffset.value)
                .alpha(0.3f)
                .size(400.dp)
                .background(color = product.color, shape = CircleShape)
        )
        IconButton(
            modifier = Modifier
                .padding(start = 22.dp, top = 42.dp)
                .shadow(elevation = 24.dp, spotColor = Shadow, shape = RoundedCornerShape(12.dp))
                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                .size(36.dp),
            onClick = goBackClick
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Back Icon",
                tint = IconTint
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){
            Image(
                modifier = Modifier
                    .scale(animatedSneakerScale.value)
                    .rotate(animatedSneakerRotate.value)
                    .padding(end = 48.dp)
                    .padding(top = 38.dp)
                    .size(320.dp),
                painter = painterResource(id = product.imageResource),
                contentDescription = "Product Image"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp)
                    .padding(top = 48.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Sneaker",
                        color = LightText,
                        fontSize = 10.sp,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 2.dp),
                        text = "Product ${product.name}",
                        color = DarkText,
                        fontSize = 22.sp,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(18.dp),
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Rating Icon",
                            tint = Star
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 4.dp),
                            textAlign = TextAlign.Center,
                            text = product.rating.toString(),
                            fontSize = 12.sp,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp),
                    text = "$${product.price}",
                    color = Accent,
                    fontSize = 36.sp,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }
            Text(
                modifier = modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 24.dp),
                text = "Size",
                color = MediumText,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProductSizeCard(
                    size = SIZE_38,
                    isSelected = selectedSize == SIZE_38
                ) {
                    selectedSize = SIZE_38
                }
                ProductSizeCard(
                    size = SIZE_38,
                    isSelected = selectedSize == SIZE_39
                ) {
                    selectedSize = SIZE_39
                }
                ProductSizeCard(
                    size = SIZE_38,
                    isSelected = selectedSize == SIZE_40
                ) {
                    selectedSize = SIZE_40
                }
                ProductSizeCard(
                    size = SIZE_38,
                    isSelected = selectedSize == SIZE_41
                ) {
                    selectedSize = SIZE_41
                }
            }
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 22.dp),
                text = "Color",
                color = MediumText,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProductColor(
                    color = product.color,
                    isSelected = selectedColor == product.color
                ) {
                    selectedColor = product.color
                }
                ProductColor(
                    color = Alternative_1,
                    isSelected = selectedColor == Alternative_1
                ) {
                    selectedColor = Alternative_1
                }
                ProductColor(
                    color = Alternative_2,
                    isSelected = selectedColor == Alternative_2
                ) {
                    selectedColor = Alternative_2
                }
            }

            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 22.dp),
                text = "Introducing the \"Futurist Glide,\" a revolutionary sneaker designed for the modern urban explorer. Its sleek, aerodynamic silhouette is crafted from sustainable, high-performance materials, offering both unparalleled comfort and eco-conscious style. The upper features a unique, breathable mesh pattern, seamlessly integrated with adaptive lacing technology for a snug, custom fit.",
                color = LightText,
                fontSize = 12.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Light,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier
                        .scale(animatedIconScale.value),
                    onClick = {
                        isFavourite = !isFavourite
                    }
                ) {
                    Icon(
                        imageVector = if (isFavourite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = "Favourite Icon",
                        tint = if (isFavourite) Favorite else IconTint
                    )
                }
                Button(
                    modifier = Modifier
                        .scale(animatedButtonScale.value)
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Accent
                    ),
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(
                        text = "Add to cart"
                    )
                }
            }
        }
    }
}


@Composable
fun ProductSizeCard(
    modifier: Modifier = Modifier,
    size: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Accent else Color.White
    val textColor = if (isSelected) Color.White else RegularText
    val border = if (isSelected) 0.dp else 0.8.dp

    Text(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(width = border, color = Border, shape = RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable(
                onClick = onClick
            )
            .padding(12.dp),
        text = size,
        fontSize = 12.sp,
        color = textColor,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        )

    )
}

@Composable
fun ProductColor(
    modifier: Modifier = Modifier,
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) Primary else Color.Transparent
    Box(
        modifier = modifier
            .border(width = 0.5.dp, color = borderColor, shape = CircleShape)
            .padding(3.dp)
            .background(color = color, shape = CircleShape)
            .size(12.dp)
            .clickable(
                onClick = onClick
            )
    )
}


@Preview
@Composable
fun ProductDetailContentPreview() {
    ShoesAppUITheme {
        ProductDetailsContent(
            product = ProductUiModel(
                imageResource = R.drawable.s_1,
                color = Product_1,
                name = "SA",
                price = 128.99f,
                oldPrice = 168.99f,
            ),
            goBackClick = {}
        )
    }
}

















