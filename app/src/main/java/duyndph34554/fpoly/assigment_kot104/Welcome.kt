package duyndph34554.fpoly.assigment_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class Welcome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Image Welcome",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column (
            modifier = Modifier.padding(30.dp)
        ) {
            Spacer(modifier = Modifier.height(170.dp))
            Text(text = "MAKE YOUR",
                fontSize = 27.sp,
                fontWeight = FontWeight(600),
                color = Color("#606060".toColorInt())
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "HOME BEAUTIFUL",
                fontSize = 36.sp,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.padding(15.dp))
            
            Text(text = "The best simple place where you " +
                    "discover most wonderful furnitures " +
                    "and make your home beautiful",
                modifier = Modifier.padding(start = 28.dp),
                color = Color("#808080".toColorInt()),
                fontSize = 17.sp,
                textAlign = TextAlign.Justify,
                lineHeight = 35.sp,
                fontWeight = FontWeight(400)
                )

            Spacer(modifier = Modifier.height(150.dp))

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    navController.navigate("login")
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color("#242424".toColorInt()),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .width(159.dp)
                        .height(54.dp),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Get Started",
                        fontFamily = FontFamily.Serif,
                        fontSize = 18.sp
                    )
                }
            }


            
        }

    }

}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController = navController)}
        composable("login") { LoginScreen()}
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showWelcome() {
    MainScreen()
}