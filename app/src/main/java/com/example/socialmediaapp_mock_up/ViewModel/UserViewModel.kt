package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData
import com.example.socialmediaapp_mock_up.database.UserDatabase

class UserViewModel(application: Application) : ViewModel() {

    val userData: UserData = UserData()

    private val _userLiveData = MutableLiveData<List<User>>()
    val dataSource = UserDatabase.getInstance(application).userDatabaseDao
    val userLiveData: LiveData<List<User>> = _userLiveData

    fun loadUserData() {
        _userLiveData.value = dataSource.getAllUsers()
    }

}