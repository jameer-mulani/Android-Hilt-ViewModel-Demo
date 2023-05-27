package com.example.daggerhiltdemo.data.api.helper

import com.example.daggerhiltdemo.data.model.User
import retrofit2.Response

//Contract to communicate with ApiService MUST BE implemented
interface ApiContract {

    suspend fun getUsers() : Response<List<User>>

}