package com.example.app_projet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.app_projet.ui.theme.App_projetTheme

class MainSignupProvider : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_projetTheme {
                SignupScreen_2()
            }
        }
    }
}

@Composable
fun SignupScreen_2() {
    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue()) }
    var wilaya by remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF0077B6), Color(0xFFB0BAD8)),
                    start = Offset(50f, 50f),
                    end = Offset(50f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ellipse_7_1),
            contentDescription = "Background Curve",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp) // Reduced height to prevent overlapping
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 32.dp)
                .verticalScroll(rememberScrollState()), // Ensures scrolling
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextField_2(value = wilaya, onValueChange = { wilaya = it.also { println("Wilaya Input: ${it.text}") } }, label = "Wilaya")
            // Forced to appear first
            CustomTextField_2(value = firstName, onValueChange = { firstName = it }, label = "First Name")
            CustomTextField_2(value = lastName, onValueChange = { lastName = it }, label = "Last Name")
            CustomTextField_2(value = email, onValueChange = { email = it }, label = "Email")
            CustomTextField_2(value = password, onValueChange = { password = it }, label = "Password", isPassword = true)
            CustomTextField_2(value = confirmPassword, onValueChange = { confirmPassword = it }, label = "Confirm Password", isPassword = true)
            CustomTextField_2(value = phoneNumber, onValueChange = { phoneNumber = it }, label = "Phone Number")

            Button(
                onClick = { /* Handle Sign Up */ },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Sign Up", fontSize = 18.sp)
            }

            Text(
                text = "Already have an account? Login",
                color = Color.Blue,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 50.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField_2(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.5.dp, Color.Blue, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.Blue
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview_2() {
    App_projetTheme {
        SignupScreen()
    }
}
