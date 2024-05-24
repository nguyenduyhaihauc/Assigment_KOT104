package duyndph34554.fpoly.assigment_kot104.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
fun NotificationScreen(navController: NavHostController) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        content = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    CustomTopBar(
                        title = "Notification",
                        subtitle = null,
                        leftIconId = R.drawable.iconsearch,
                        rightIconId =null,
                        onLeftClick = {  },
                        onRightClick = { }) {}
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    NotifiScreen(notifi = Notifi.getNotifi())

                }

            }
        }
    )
}

@Composable
fun NotifiScreen(notifi: List<Notifi>) {
    LazyColumn (
        state = rememberLazyListState(),
//        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(notifi.size) {
            index -> ItemNotifi(notifi = notifi[index]) 
        }
    }
}

@Composable
fun ItemNotifi(notifi: Notifi){
    Row (
        modifier = Modifier.padding(10.dp)
    ) {
        Image(painter = painterResource(id = notifi.imagNoti),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        
        Spacer(modifier = Modifier.width(5.dp))
        Column (
            
        ) {
            Text(text = notifi.peasonSend,
                fontSize = 11.sp,
                fontWeight = FontWeight(700),
                color = Color("#242424".toColorInt())
            )

            Text(text = notifi.content,
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color("#808080".toColorInt())
            )
        }
    }
}

data class Notifi(
    val imagNoti: Int,
    val peasonSend: String,
    val content: String
) {
    companion object {
        fun getNotifi() = listOf(
            Notifi(R.drawable.cart1, "Your order #123456789 has been confirmed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. "),
            Notifi(R.drawable.cart2, "Your order #123456789 has been canceled", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. "),
            Notifi(R.drawable.cart1, "Your order #123456789 has been confirmed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. "),
            Notifi(R.drawable.cart2, "Your order #123456789 has been canceled", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. "),
            Notifi(R.drawable.cart1, "Your order #123456789 has been confirmed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. "),
            Notifi(R.drawable.cart2, "Your order #123456789 has been canceled", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. "),
        )
    }
}