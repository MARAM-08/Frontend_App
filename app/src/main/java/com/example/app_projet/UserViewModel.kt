package com.example.app_projet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import androidx.compose.runtime.*

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    var userList by mutableStateOf<List<User>>(emptyList())
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response: Response<List<User>> = repository.fetchUsers()
                if (response.isSuccessful) {
                    userList = response.body() ?: emptyList()
                } else {
                    errorMessage = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage = "Network Error: ${e.message}"
            }
        }
    }
}