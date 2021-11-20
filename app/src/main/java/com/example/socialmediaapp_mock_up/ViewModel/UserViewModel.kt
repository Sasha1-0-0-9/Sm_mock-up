package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.database.UserDatabase

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val dataSource = UserDatabase.getInstance(application).userDatabaseDao
    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    fun loadUserData() {
        _userLiveData.value = dataSource.getAllUsers()
    }

    fun insert() {
        if (dataSource.getUser() == null) {
            for (user in dataSource.getAllUsers())
                dataSource.insert(user)
        }
    }

    fun getAll(): List<User> {
        return dataSource.getAllUsers()
    }
}