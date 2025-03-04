package com.example.my_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.benchmark.perfetto.ExperimentalPerfettoTraceProcessorApi
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my_app.ui.theme.My_AppTheme
import java.time.format.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPerfettoTraceProcessorApi::class, ExperimentalMaterial3Api::class)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My_AppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF0077B6)
                ) {
                    Row () {

                        Text(
                            text = "Welcome back!",
                            Modifier
                                .width(503.dp)
                                .height(248.dp)
                                .offset( y = 189.dp),
                            textAlign = TextAlign.Center,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 33.sp,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFFFFFFFF)
                            )
                        )
                        }
                    Image(
                        painter = painterResource(id = R.drawable.ellipse),
                        contentDescription = "image description",
                        modifier = Modifier
                            .offset(y = 160.dp),
                        contentScale = ContentScale.Fit,
                        alignment = Center
                    )

                Column {
                    Button(
                        onClick = { /* TODO: Add your click handling logic here */ },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0077B6)),
                        modifier = Modifier
                            .width(348.dp)
                            .height(39.dp)
                            .offset(x=32.dp , y = 558.dp)
                    ) {
                        Text(text = "Login", color = Color.White, textAlign = TextAlign.Center)
                    }
                    FilledTonalButton(
                        onClick = { /* TODO: Add your click handling logic here */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xAA6BA6FF) ),
                        modifier = Modifier
                            .width(348.dp)
                            .height(39.dp)
                            .offset(x=32.dp , y = 684.dp)
                    ) {
                        Text("Continue with Google", color = Color.Black, textAlign = TextAlign.Center)
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "image description",
                            Modifier
                                .width(24.dp)
                                .height(24.dp)
                                //.offset(x = 296.dp , y = 695.dp)
                        )

                    }
                    Text(
                        buildAnnotatedString {
                            append("You don't have an account? ")
                            withStyle(style = SpanStyle(color = Color(0xFF0077B6))) {
                                append("Sign Up")
                            }
                        },
                        modifier = Modifier.offset(x = 74.dp, y = 760.dp),
                        color = Color(0xFF000000)
                    )
                    Text(
                        text = "OR",
                        Modifier
                            .offset(x = 195.93.dp , y  = 540.dp),
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF355BA4),
                        )
                    )
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .width(135.39.dp)
                            .height(1.dp)
                            .offset(x= 55.dp , y = 528.dp)
                            .background(color = Color(0xFF5D5C5C))
                    ) {
                        // Add content here if needed
                    }
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .width(135.39.dp)
                            .height(1.dp)
                            .offset(x= 223.49.dp , y = 528.dp)
                            .background(color = Color(0xFF5D5C5C))
                    ) {
                        // Add content here if needed
                    }
                    Row()

                     {
                    Text(
                        text = "Forgot password?",
                        Modifier
                            .offset(x = 244.dp, y = 390.dp),
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF383737)
                        )
                    )
                         Text(
                             text = "Remember me",
                             Modifier
                                 .offset(x = -70.dp , y = 390.dp),
                             style = androidx.compose.ui.text.TextStyle(
                                 fontSize = 14.sp,
                                 fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                 fontWeight = FontWeight(500),
                                 color = Color(0xFF343333),
                             )
                         )
                         Image(
                             painter = painterResource(id = R.drawable.check),
                             contentDescription = "image description",
                             contentScale = ContentScale.FillBounds,
                             modifier = Modifier
                                 .width(18.dp)
                                 .height(18.dp)
                                 .offset(x = -205.dp , y = 392.dp)
                         )

                             Box(
                                 modifier = Modifier
                                     .border(width = 1.dp, color = Color(0xCC000000))
                                     .width(18.dp)
                                     .height(18.dp)
                                     //.offset(x = 5.dp, y = 1000.dp)
                                     .background(color = Color(0xFFFFFFFF))
                             )



                     }
                    LoginScreen()
                }

                }
                }

            }
        }


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = 100.dp)
            .padding(horizontal = 32.dp, vertical = 100.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email or Username") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF2C69DE),
                unfocusedBorderColor = Color(0xFF2C69DE),
                containerColor = Color.White
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF2C69DE),
                unfocusedBorderColor = Color(0xFF2C69DE),
                containerColor = Color.White
            )
        )
    }
}




@Composable
fun Login(name: String) {
    Text(text = name)
}




@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    My_AppTheme {
        Column {
            Login("Android")

        }
    }
}
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}