package duyndph34554.fpoly.assigment_kot104.screen


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle

import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import duyndph34554.fpoly.assigment_kot104.R
import duyndph34554.fpoly.assigment_kot104.compoment.CustomTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavouriteScreen(navController: NavHostController) {
    val productList = remember {
        mutableStateListOf(
            Product(R.drawable.img_lamp, "Black Simple Lamp", "$ 12.00", 50, "Ngon bá cháy"),
            Product(R.drawable.img_desk1, "Minimal Stand", "$ 25.00", 53, "Ngon bá khét"),
            Product(R.drawable.img_chair, "Coffee Chair", "$ 20.00", 55, "Ngon bá bá"),
            Product(R.drawable.img_desk, "Simple Desk", "$ 50.00", 52, "Ngon bá khí"),
            Product(R.drawable.img_desk1, "Normal Desk", "$ 40.00", 59, "Ngon bá đạo"),
            Product(R.drawable.img_desk, "Hard Desk", "$ 60.00", 56, "Ngon bá bú"),
            Product(R.drawable.img_lamp, "Soft Desk", "$ 70.00", 54, "Ngon bá chó"),
            Product(R.drawable.img_chair, "Office Desk", "$ 80.00", 55, "Ngon bá chém")
        )
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        content = {
            Box(
//                modifier = Modifier.fillMaxSize()

            ) {
                Column(
                    modifier = Modifier
//                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    CustomTopBar(
                        title = "My favourite",
                        subtitle = null,
                        leftIconId = R.drawable.back,
                        rightIconId = R.drawable.iconcart,
                        onLeftClick = { navController.popBackStack() },
                        onRightClick = { navController.navigate("cart") }
                    ) {}
                    Spacer(modifier = Modifier.height(16.dp))
                    ProductList(productList)
                    
                    Spacer(modifier = Modifier.height(10.dp))

                    AddAllToCartButton(
                        onClick = { /* Handle add all to cart */ },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    
                    Spacer(modifier = Modifier.height(80.dp))
                }
                
            }
        }
    )
}

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn {
        items(products.size) { index ->
            val product = products[index]
            ProductItem(
                product = product,
                onAddToCart = { /* TODO: Handle add to cart */ },
                onRemove = { /* TODO: Handle remove item */ }
            )
//            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun ProductItem(product: Product, onAddToCart: () -> Unit, onRemove: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White) // Change this to desired color

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = product.name,
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp,
                    color = Color("#606060".toColorInt())
                )
                Text(text = product.price,
                    fontSize = 16.sp,
                    color = Color("#303030".toColorInt()),
                    fontWeight = FontWeight(700)
                )
            }
            Column {
                IconButton(onClick = onRemove) {
                    Icon(painter = painterResource(id = R.drawable.delete_cart),
                        contentDescription = "Remove",
                        modifier = Modifier.size(20.dp))
                }
                IconButton(onClick = onAddToCart) {
                    Icon(painter = painterResource(id = R.drawable.add_favorite),
                        contentDescription = "Add to Cart",
                        modifier = Modifier.size(20.dp))
                }
            }

        }
    }
}

@Composable
fun AddAllToCartButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Add all to my cart", 
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight(600)
        )
    }
}