package com.example.app_projet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.input.TextFieldValue
import com.example.app_projet.ui.theme.App_projetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_projetTheme {
                SignupScreen()
                UserListScreen()
            }
        }
    }
}

@Composable
fun SignupScreen() {
    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF2193b0), // Blueish
                        Color(0xFF6dd5ed)  // Light Blue
                    ),
                    start = Offset(50f, 50f), // Top-left corner
                    end = Offset(50f, Float.POSITIVE_INFINITY) // Bottom
                )
            )
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.ellipse_7_1),
            contentDescription = "Background Curve",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(900.dp)
                .offset(y = 100.dp) // Moved down for better alignment
        )

        // Airplane Image
        Image(
            painter = painterResource(id = R.drawable.airplane_correct_1),
            contentDescription = "Airplane",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(180.dp) // Slightly smaller for balance
                .height(90.dp)
                .offset(x = 248.dp, y = 38.dp) // Adjusted position
        )

        // Input Fields and Button
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone number") },
                modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
            )

            Button(
                onClick = { /* Handle Sign Up */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
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
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        visualTransformation = if (label.contains("Password")) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.5.dp, Color.Blue, RoundedCornerShape(12.dp)), // Custom border radius and color
        shape = RoundedCornerShape(12.dp), // Rounder corners
        colors = TextFieldDefaults.run {
            outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Border color when focused
                unfocusedBorderColor = Color.Gray, // Border color when not focused
                cursorColor = Color.Blue, // Cursor color

            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    App_projetTheme {
        SignupScreen()
    }
}
