package duyndph34554.fpoly.assigment_kot104.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import duyndph34554.fpoly.assigment_kot104.R

class Sign : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SignScreen(navController = navController)
        }
    }
}

@Composable
fun SignScreen(navController: NavHostController) {

    var passwordVisiable by remember {
        mutableStateOf(false)
    }

    var respassword by remember {
        mutableStateOf(false)
    }

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var confirmpass by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.padding(30.dp)
    ) {
        Row (
//            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.width(100.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Image(painter = painterResource(id = R.drawable.iconlogin),
                contentDescription = "icon Login",
                modifier = Modifier
                    .width(63.dp)
                    .height(63.dp))
            
            Spacer(modifier = Modifier.width(20.dp))

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.width(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "WELCOME",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = Color.Black,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column (
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
            ) {
                Text(text = "Name",
                    fontSize = 14.sp,
                    color = Color("#909090".toColorInt())
                )

                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(value = name,
                    onValueChange = {name = it},
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text(text = "Email",
                    fontSize = 14.sp,
                    color = Color("#909090".toColorInt())
                )

                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(value = email,
                    onValueChange = {email = it},
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Password",
                    fontSize = 14.sp,
                    color = Color("#909090".toColorInt())
                )

                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(value = password,
                    onValueChange = {password = it},
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (!passwordVisiable) PasswordVisualTransformation() else VisualTransformation.None,
                    trailingIcon = {
                        val image: Painter = if (passwordVisiable) {
                            painterResource(id = R.drawable.visibility)
                        }else{
                            painterResource(id = R.drawable.visibilityoff)
                        }

                        IconButton(onClick = { passwordVisiable =! passwordVisiable}) {
                            Icon(painter = image,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp))
                        }
                    }
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text(text = "Confirm Password",
                    fontSize = 14.sp,
                    color = Color("#909090".toColorInt())
                )

                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(value = confirmpass,
                    onValueChange = {confirmpass = it},
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        val image: Painter = if (respassword) {
                            painterResource(id = R.drawable.visibility)
                        } else {
                            painterResource(id = R.drawable.visibilityoff)
                        }

                        IconButton(onClick = { respassword =! respassword }) {
                            Icon(painter = image,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp))
                        }
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color("#242424".toColorInt()),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "SIGN UP",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.padding(horizontal = 0.dp, vertical = 6.dp)
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Already have account? ",
                        fontSize = 14.sp,
                        color = Color("#909090".toColorInt()),
                        fontWeight = FontWeight(600)
                    )

                    Text(text = "SIGN IN",
                        fontWeight = FontWeight(700),
                        fontSize = 14.sp
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showSign() {

}