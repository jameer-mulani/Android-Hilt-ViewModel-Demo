package com.example.daggerhiltdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
class AboutUsModule {

    @Provides
    @CopyrightInfo
    @ViewModelScoped
    fun provideCopyrightLabel() : String =
        "Copyright 2023, All rights are reserved and inclusive to corporate business interest"

}