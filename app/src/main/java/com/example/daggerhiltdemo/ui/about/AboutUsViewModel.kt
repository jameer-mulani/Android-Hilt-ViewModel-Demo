package com.example.daggerhiltdemo.ui.about

import androidx.lifecycle.ViewModel
import com.example.daggerhiltdemo.di.CopyrightInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutUsViewModel @Inject constructor(
    @CopyrightInfo private val copyrightInfo: String
) : ViewModel() {

    fun getCopyRightInfo() = copyrightInfo

}