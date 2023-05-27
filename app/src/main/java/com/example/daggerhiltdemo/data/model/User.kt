package com.example.daggerhiltdemo.data.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "id") val id : Int = 0,
    @Json(name = "name") val name : String = "NA",
    @Json(name = "email") val email : String = "NA",
    @Json(name = "avatar") val avatar : String = ""
)
