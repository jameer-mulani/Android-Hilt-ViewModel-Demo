package com.example.daggerhiltdemo.data.api

import com.example.daggerhiltdemo.data.model.User
import retrofit2.Response
import retrofit2.http.GET

//Retrofit Api Service
interface ApiService {

    @GET("users")
    suspend fun getUsers() : Response<List<User>>

}