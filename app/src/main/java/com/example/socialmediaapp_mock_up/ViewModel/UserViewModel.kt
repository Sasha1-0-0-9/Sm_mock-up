package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData
import com.example.socialmediaapp_mock_up.database.UserDatabase

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userData: UserData = UserData()
    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    private val dataSource = UserDatabase.getInstance(application).userDatabaseDao

    fun loadUserData() {
        _userLiveData.value = dataSource.getAllUsers()
    }
}