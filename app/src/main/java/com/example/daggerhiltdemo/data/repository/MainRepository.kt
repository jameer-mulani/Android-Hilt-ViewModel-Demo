package com.example.daggerhiltdemo.data.repository

import com.example.daggerhiltdemo.data.api.helper.ApiContract
import javax.inject.Inject

/**
 * Application Repository helps to access the application data layer, uses the [ApiContract] to access the data
 *
 * Dependencies:
 *
 * [MainRepository]---uses--->[ApiContract]
 *
 */
class MainRepository @Inject constructor(private val apiContract: ApiContract) {

    suspend fun getUsers() = apiContract.getUsers()
}