package duyndph34554.fpoly.assigment_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.padding(30.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.iconlogin),
                contentDescription = "icon Login",
                modifier = Modifier
                    .width(63.dp)
                    .height(63.dp))
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Hello !",
            fontSize = 24.sp,
            fontWeight = FontWeight(400),
            color = Color("#909090".toColorInt())
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "WELCOME BACK",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column (
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)
            ) {
                Text(text = "Email",
                    fontSize = 14.sp,
                    color = Color("#909090".toColorInt())
                )

                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(value = email,
                    onValueChange = {email = it},
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Password",
                    fontSize = 14.sp,
                    color = Color("#909090".toColorInt())
                )

                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(value = password,
                    onValueChange = {password = it},
                    modifier = Modifier.fillMaxWidth())



                Text(text = "Forgot Password",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 20.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    )

                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color("#242424".toColorInt()),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Log in",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.padding(horizontal = 0.dp, vertical = 6.dp)
                    )
                }

                Text(text = "SIGN UP",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color("#303030".toColorInt())
                )

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showLogin() {
    LoginScreen()
}