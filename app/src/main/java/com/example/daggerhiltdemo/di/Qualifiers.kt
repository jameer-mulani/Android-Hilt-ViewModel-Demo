package com.example.daggerhiltdemo.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LibraryKey

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiKey