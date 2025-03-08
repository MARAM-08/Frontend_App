@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.app_projet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserSignUpScreen(userViewModel: UserViewModel = viewModel()) {
    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFE3F2FD),
        topBar = {
            TopAppBar(title = { Text("Sign Up") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignUpTextField("First Name", firstName) { firstName = it }
            SignUpTextField("Last Name", lastName) { lastName = it }
            SignUpTextField("Email", email) { email = it }
            SignUpTextField("Password", password) { password = it }
            SignUpTextField("Confirm Password", confirmPassword) { confirmPassword = it }
            SignUpTextField("Phone Number", phoneNumber) { phoneNumber = it }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Handle sign up */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF007AFF))
            ) {
                Text("Sign Up", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))
            TextButton(onClick = { /* Handle login navigation */ }) {
                Text("Already have an account? Login", color = Color.Blue)
            }
        }
    }
}

@Composable
fun SignUpTextField(label: String, value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = MaterialTheme.shapes.medium
    )
}

@Preview
@Composable
fun PreviewUserSignUpScreen() {
    UserSignUpScreen()
}


class UserListScreen {

}
