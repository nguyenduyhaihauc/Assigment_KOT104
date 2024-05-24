package duyndph34554.fpoly.assigment_kot104.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import duyndph34554.fpoly.assigment_kot104.R
import duyndph34554.fpoly.assigment_kot104.compoment.CustomTopBar
import duyndph34554.fpoly.assigment_kot104.navigation.bottom_navhost
import duyndph34554.fpoly.assigment_kot104.ui.theme.Assigment_KOT104Theme

//data class Icon(
//    val imageIcon: Int,
//    val titleIcon: String
//) {
//    companion object {
//        fun getDsIcon(): List<Icon> = listOf(
//            Icon(R.drawable.chair, "Popular"),
//            Icon(R.drawable.chair, "Chair"),
//            Icon(R.drawable.table, "Table"),
//            Icon(R.drawable.sofa, "Armchair"),
//            Icon(R.drawable.bed, "Bed")
//        )
//    }
//}
//
//data class Products(
//    val imgProduct: Int,
//    val nameProduct: String,
//    val priceProduct: Double
//){
//    companion object{
//        fun getDSProduct(): List<Products> = listOf(
//            Products(R.drawable.home1, "Black Simple Lamp", 12.00),
//            Products(R.drawable.home2, "Minimal Stand", 25.00),
//            Products(R.drawable.home3, "Coffee Chair", 20.00),
//            Products(R.drawable.home, "Simple Desk", 50.00)
//        )
//    }
//}
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Assigment_KOT104Theme {
////                HomeScreen(Icon.getDsIcon(), Products.getDSProduct())
//
//                val navController = rememberNavController()
//
//                Scaffold (
//                    bottomBar = {
//                        BottomNavigationBar(navController = navController)
//                    }
//                ) {
//                    paddingValues ->
//                    Box (
//                        modifier = Modifier.padding(paddingValues)
//                    ) {
//                        bottom_navhost(navController = navController)
//                    }
//                }
//
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun HomeNew(navController: NavController) {
//
//    HomeScreen(icons = Icon.getDsIcon(), products = Products.getDSProduct())
//}
//
//@Composable
//fun HomeScreen(icons: List<Icon>, products: List<Products>) {
//    Box (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        Column (
//            modifier = Modifier
//                .padding(16.dp).fillMaxSize()
//        ) {
//            Row (
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Image(painter = painterResource(id = R.drawable.iconsearch),
//                    contentDescription = "iconSearch",
//                    modifier = Modifier
//                        .size(24.dp))
//
//                Column (
//                    modifier = Modifier.weight(1f),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(text = "Make home",
//                        fontSize = 18.sp,
//                        color = Color("#999999".toColorInt()),
//                        fontWeight = FontWeight(400)
//                    )
//                    Text(text = "BEAUTIFUL",
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight(700)
//                    )
//                }
//
//                Image(painter = painterResource(id = R.drawable.iconcart),
//                    contentDescription = "icon cart",
//                    modifier = Modifier.size(24.dp))
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
////        List Icon
//            LazyRow (
//                state = rememberLazyListState(),
//                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
//                horizontalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                items(icons.size) {
//                        index -> IconItem(icon = icons[index])
//                }
//            }
//
//            Spacer(modifier = Modifier.height(25.dp))
//
//            val gridProduct = rememberLazyStaggeredGridState()
//
//            LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
//                state = gridProduct,
//                horizontalArrangement = Arrangement.spacedBy(12.dp),
//                verticalItemSpacing = 12.dp,
//
//                ) {
//                items(products.size) {
//                        index -> ItemProduct(products = products[index])
//                }
//            }
//        }
//    }
//}
//
////Item Product
//@Composable
//fun ItemProduct(products: Products) {
//    val imgProduct: Painter = painterResource(id = products.imgProduct)
//
//    Column (
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(vertical = 5.dp)
//    ) {
//        Image(painter = imgProduct,
//            contentDescription = "image Product",
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1f))
//
//        Text(text = products.nameProduct,
//            color = Color("#606060".toColorInt()),
//            fontSize = 14.sp,
//            fontWeight = FontWeight(400),
//            modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 0.dp, bottom = 10.dp)
//        )
//        Text(text = "$ ${products.priceProduct}",
//            fontWeight = FontWeight(700),
//            fontSize = 14.sp,
//            color = Color("#303030".toColorInt()),
//            modifier = Modifier.padding(start = 20.dp)
//        )
//    }
//}
//
//// Ham Icon Item
//@Composable
//fun IconItem(icon: Icon) {
//    val painter: Painter = painterResource(id = icon.imageIcon)
//    Column (
//        modifier = Modifier
//            .wrapContentWidth()
//            .wrapContentHeight(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Card (
//            colors = CardDefaults.cardColors(
//                containerColor = Color.White
//            ),
//            modifier = Modifier
//                .size(70.dp),
//
//        ) {
//            Box(contentAlignment = Alignment.Center,
//                modifier = Modifier.fillMaxSize()){
//                Image(painter = painter,
//                    contentDescription = "image Icon",
//                    modifier = Modifier.size(40.dp))
//            }
//
//        }
//
//        Text(text = icon.titleIcon,
//            color = Color("#999999".toColorInt()),
//            fontSize = 14.sp,
//            fontWeight = FontWeight(400),
//            modifier = Modifier.padding(top = 6.dp)
//        )
//    }
//}
//
////Quan ly thanh BottomNavigation
//
//@Composable
//fun BottomNavigationBar(navController: NavController) {
//    var selectedItem by remember {
//        mutableStateOf("home")
//    }
//
//    NavigationBar (
//        containerColor = Color.White
//    ) {
//        NavigationBarItem(
//            selected = selectedItem == "home",
//            onClick = {
//                      selectedItem = "home"
//                navController.navigate("home")
//            },
//            icon = {
//                Icon(painter = painterResource(id = R.drawable.ic_home),
//                    contentDescription = "icon Home",
//                    modifier = Modifier.size(24.dp)
//                )
//            },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Color.Black,
//                unselectedIconColor = Color.Gray,
//                indicatorColor = Color.White
//            ),
//            alwaysShowLabel = false
//        )
//
////        icon Favorite
//        NavigationBarItem(
//            selected = selectedItem == "favorite",
//            onClick = {
//                selectedItem = "favorite"
//                navController.navigate("favorite")
//            },
//            icon = {
//                Icon(painter = painterResource(id = R.drawable.ic_favorite),
//                    contentDescription = "icon Favorite",
//                    modifier = Modifier.size(24.dp)
//                )
//            },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Color.Black,
//                unselectedIconColor = Color.Gray,
//                indicatorColor = Color.White
//            ),
//            alwaysShowLabel = false
//        )
//    }
//}
//
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    Assigment_KOT104Theme {
//
//    }
//}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home() {

    val bottomnavController = rememberNavController()


    Scaffold(
        bottomBar = { BottomNavigationBar(bottomnavController) }
    ) {
        bottom_navhost(bottomnavController)
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(nav: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            CustomTopBar(
                title = "Make home",
                subtitle ="Beautiful",
                leftIconId =R.drawable.iconsearch,
                rightIconId =R.drawable.iconcart,
                onLeftClick = {  },
                onRightClick = {
                    nav.navigate("cart")
                }

            ) {}
            Spacer(modifier = Modifier.height(16.dp))
            CategoryRow()
            Spacer(modifier = Modifier.height(16.dp))
            ProductGrid()
        }
    }

}


@Composable
fun CategoryRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CategoryItem(R.drawable.start, "Popular")
        CategoryItem(R.drawable.chair, "Chair")
        CategoryItem(R.drawable.table, "Table")
        CategoryItem(R.drawable.sofa, "Armchair")
        CategoryItem(R.drawable.bed, "Bed")
    }
}

@Composable
fun CategoryItem(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(8.dp)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }
}

@Composable
fun ProductGrid(
) {
    val products = listOf(
        Product(R.drawable.home1, "Black Simple Lamp", "$ 12.00", 50, "Ngon bá cháy"),
        Product(R.drawable.home2, "Minimal Stand", "$ 25.00", 53, "Ngon bá khét"),
        Product(R.drawable.home3, "Coffee Chair", "$ 20.00", 55, "Ngon bá bá"),
        Product(R.drawable.home, "Simple Desk", "$ 50.00", 52, "Ngon bá khí"),
        Product(R.drawable.home1, "Normal Desk", "$ 40.00", 59, "Ngon bá đạo"),
        Product(R.drawable.home2, "Hard Desk", "$ 60.00", 56, "Ngon bá bú"),
        Product(R.drawable.home3, "Soft Desk", "$ 70.00", 54, "Ngon bá chó"),
        Product(R.drawable.home, "Office Desk", "$ 80.00", 55, "Ngon bá chém"),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 60.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductItem(products[index])
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = product.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = product.price,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun BottomNavigationBar(nav: NavController) {
    var selectedItem by remember { mutableStateOf("home") }

    NavigationBar(
        containerColor = Color.White,
    ) {

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                )
            },
            selected = selectedItem == "home",
            onClick = {
                selectedItem = "home"
                nav.navigate("home")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.White
            ),
            alwaysShowLabel = false,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Favourite",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = selectedItem == "favourite",
            onClick = {
                selectedItem = "favourite"
                nav.navigate("favourite")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.White
            ),
            alwaysShowLabel = false,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = selectedItem == "notification",
            onClick = {
                selectedItem = "notification"
                nav.navigate("notification")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.White
            ),
            alwaysShowLabel = false,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = selectedItem == "profile",
            onClick = {
                selectedItem = "profile"
                nav.navigate("profile")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.White
            ),
            alwaysShowLabel = false,
        )
    }
}

data class Product(
    val imageRes: Int,
    val name: String,
    val price: String,
    val quantity: Int,
    val description: String
)