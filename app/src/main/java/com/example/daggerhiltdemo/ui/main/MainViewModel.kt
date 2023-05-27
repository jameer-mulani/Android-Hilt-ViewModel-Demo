package com.example.daggerhiltdemo.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltdemo.data.model.User
import com.example.daggerhiltdemo.data.repository.MainRepository
import com.example.daggerhiltdemo.di.ApiKey
import com.example.daggerhiltdemo.di.LibraryKey
import com.example.daggerhiltdemo.utils.NetworkHelper
import com.example.daggerhiltdemo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val mainRepository: MainRepository,
    @ApiKey private val apiKey: String,
    @LibraryKey private val libraryKey: String
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()

    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {

        Log.d("mainviewmodel", "Apikey : $apiKey, libraryKey: $libraryKey")

        viewModelScope.launch {
            //emit loading state
            _users.postValue(Resource.loading(data = null, message = null))

            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(data = it.body()))
                    } else {
                        //emit failed to get users, try again!
                        _users.postValue(
                            Resource.failed(
                                data = null,
                                message = "Failed to get users, try again!"
                            )
                        )
                    }
                }
            } else {
                //emit no internet connection failed state.
                _users.postValue(Resource.failed(data = null, message = "No internet connection"))
            }


        }
    }

}