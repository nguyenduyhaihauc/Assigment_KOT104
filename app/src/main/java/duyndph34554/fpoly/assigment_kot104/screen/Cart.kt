package duyndph34554.fpoly.assigment_kot104.screen

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.compose.rememberNavController
import duyndph34554.fpoly.assigment_kot104.R
import duyndph34554.fpoly.assigment_kot104.compoment.CustomTopBar

data class CartItem(
    val image: Int,
    val name: String,
    val price: Double,
    var quantity: Int
)


class Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            val navNavigation = rememberNavController()
            CarScreen(navController = navNavigation)
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CarScreen(navController: NavHostController) {
    val items = remember {
        mutableStateListOf(
            CartItem(R.drawable.cart1, "Minimal Stand", 25.0, 1),
            CartItem(R.drawable.cart2, "Coffee Table", 20.0, 1),
            CartItem(R.drawable.cart3, "Minimal Desk", 50.0, 1)
        )
    }
    val total = items.sumOf { it.price * it.quantity }



    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            CustomTopBar(
                title = "My cart",
                subtitle = null,
                leftIconId = R.drawable.back,
                rightIconId = null,
                onLeftClick = { navController.popBackStack() },
                onRightClick = { }
            ) {}

            items.forEach { item ->
                CartItemCard(item, onRemove = { items.remove(item) })
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Total: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color("#808080".toColorInt())
                )
                Text(
                    text = "$${"%.2f".format(total)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color("#303030".toColorInt())
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Chuyển đến màn hình xác nhận */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color("#242424".toColorInt())
                )
            ) {
                Text("Check out",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600)
                )
            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun CartItemCard(item: CartItem, onRemove: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
//        elevation = 4.dp, // Adds elevation to the card

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(item.name, fontWeight = FontWeight.Bold)
                    Text("$${item.price}", color = Color.Gray)
                    Spacer(modifier = Modifier.width(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 5.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            var quantity by remember { mutableStateOf(item.quantity) }
                            IconButton(onClick = { if (quantity > 1) quantity-- }) {
                                Icon(painter = painterResource(id = R.drawable.tru),
                                    contentDescription = "Decrease quantity",
                                    modifier = Modifier.size(18.dp))
                            }
                            Text("$quantity", fontSize = 18.sp)
                            IconButton(onClick = { quantity++ }) {
                                Icon(Icons.Default.Add, contentDescription  = "Increase quantity")
                            }
                        }
                    }
                }
                IconButton(onClick = onRemove) {
                    Icon(painter = painterResource(id = R.drawable.delete_cart),
                        contentDescription = "Remove item",
                        modifier = Modifier.size(24.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}


