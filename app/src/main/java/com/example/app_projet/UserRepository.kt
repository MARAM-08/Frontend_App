package com.example.app_projet

import retrofit2.Response

class UserRepository {
    suspend fun fetchUsers(): Response<List<User>> {
        return RetrofitInstance.api.getUsers()
    }
}