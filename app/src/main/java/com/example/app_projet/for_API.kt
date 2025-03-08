package com.example.app_projet

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Define data model
data class User(val id: Int, val name: String, val email: String)

// Retrofit API interface
interface ApiService {
    @GET("users") // Replace with your actual API endpoint
    suspend fun getUsers(): Response<List<User>>

    @GET("users/{id}") // Example of fetching a specific user
    suspend fun getUserById(@Path("id") userId: Int): Response<User>
}



