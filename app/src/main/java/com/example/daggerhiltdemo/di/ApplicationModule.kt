package com.example.daggerhiltdemo.di

import com.example.daggerhiltdemo.BuildConfig
import com.example.daggerhiltdemo.data.api.ApiService
import com.example.daggerhiltdemo.data.api.helper.ApiContract
import com.example.daggerhiltdemo.data.api.helper.ApiContractImpl
import com.example.daggerhiltdemo.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {


    @ApiKey
    @Provides
    fun provideApiKey() : String = "123-api-xyz"

    @LibraryKey
    @Provides
    fun provideLibraryKey() : String ="lib-key-334"

    @Provides
    @Named(value = "base_url")
    fun provideBaseUrl(): String = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkhttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("base_url") baseUrl: String): Retrofit =
        Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiContract(apiService: ApiService): ApiContract = ApiContractImpl(apiService)

    @Provides
    @Singleton
    fun provideMainRepository(apiContract: ApiContract): MainRepository =
        MainRepository(apiContract)


}