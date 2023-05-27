package com.example.daggerhiltdemo.data.api.helper

import com.example.daggerhiltdemo.data.api.ApiService
import com.example.daggerhiltdemo.data.model.User
import retrofit2.Response
import javax.inject.Inject

/**
 * Implementation of [ApiContract] to communicate via using [ApiService]
 *
 * Dependencies :
 *
 * [ApiContractImpl]---uses--->[ApiService]
 */
class ApiContractImpl @Inject constructor(private val apiService: ApiService) : ApiContract {
    override suspend fun getUsers(): Response<List<User>> {
        return apiService.getUsers()
    }
}