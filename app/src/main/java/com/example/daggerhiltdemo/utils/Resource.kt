package com.example.daggerhiltdemo.utils

class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> failed(data: T?, message: String?) = Resource(Status.FAILED, data, message)
        fun <T> loading(data: T?, message: String?) = Resource(Status.LOADING, data, message)
    }

}