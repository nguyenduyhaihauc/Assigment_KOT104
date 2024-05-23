package duyndph34554.fpoly.assigment_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import duyndph34554.fpoly.assigment_kot104.ui.theme.Assigment_KOT104Theme

data class Icon(
    val imageIcon: Int,
    val titleIcon: String
) {
    companion object {
        fun getDsIcon(): List<Icon> = listOf(
            Icon(R.drawable.chair, "Popular"),
            Icon(R.drawable.chair, "Chair"),
            Icon(R.drawable.table, "Table"),
            Icon(R.drawable.sofa, "Armchair"),
            Icon(R.drawable.bed, "Bed")
        )
    }
}

data class Products(
    val imgProduct: Int,
    val nameProduct: String,
    val priceProduct: Double
){
    companion object{
        fun getDSProduct(): List<Products> = listOf(
            Products(R.drawable.home1, "Black Simple Lamp", 12.00),
            Products(R.drawable.home2, "Minimal Stand", 25.00),
            Products(R.drawable.home3, "Coffee Chair", 20.00),
            Products(R.drawable.home, "Simple Desk", 50.00)
        )
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assigment_KOT104Theme {
                HomeScreen(Icon.getDsIcon(), Products.getDSProduct())
            }
        }
    }
}

@Composable
fun HomeScreen(icons: List<Icon>, products: List<Products>) {
    Column (
        modifier = Modifier.padding(20.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.iconsearch),
                contentDescription = "iconSearch",
                modifier = Modifier
                    .size(24.dp))

            Column (
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Make home",
                    fontSize = 18.sp,
                    color = Color("#999999".toColorInt()),
                    fontWeight = FontWeight(400)
                )
                Text(text = "BEAUTIFUL",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )
            }

            Image(painter = painterResource(id = R.drawable.iconcart),
                contentDescription = "icon cart",
                modifier = Modifier.size(24.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

//        List Icon
        LazyRow (
            state = rememberLazyListState(),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(icons.size) {
                index -> IconItem(icon = icons[index])
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        val gridProduct = rememberLazyStaggeredGridState()

        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
            state = gridProduct,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalItemSpacing = 12.dp,

        ) {
            items(products.size) {
                index -> ItemProduct(products = products[index])
            }
        }
    }
}

//Item Product
@Composable
fun ItemProduct(products: Products) {
    val imgProduct: Painter = painterResource(id = products.imgProduct)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight().padding(vertical = 5.dp)
    ) {
        Image(painter = imgProduct,
            contentDescription = "image Product",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f))

        Text(text = products.nameProduct,
            color = Color("#606060".toColorInt()),
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 0.dp, bottom = 10.dp)
        )
        Text(text = "$ ${products.priceProduct}",
            fontWeight = FontWeight(700),
            fontSize = 14.sp,
            color = Color("#303030".toColorInt()),
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

// Ham Icon Item
@Composable
fun IconItem(icon: Icon) {
    val painter: Painter = painterResource(id = icon.imageIcon)
    Column (
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card (
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .size(70.dp),

        ) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()){
                Image(painter = painter,
                    contentDescription = "image Icon",
                    modifier = Modifier.size(40.dp))
            }

        }

        Text(text = icon.titleIcon,
            color = Color("#999999".toColorInt()),
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Assigment_KOT104Theme {
        HomeScreen(Icon.getDsIcon(), Products.getDSProduct())
    }
}