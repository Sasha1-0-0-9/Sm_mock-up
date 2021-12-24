package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData
import com.example.socialmediaapp_mock_up.database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userData: UserData = UserData()
    private val dataSource = UserDatabase.getInstance(application).userDatabaseDao
    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    init {
        viewModelScope.launch {
            insert()
        }
        viewModelScope.launch(Dispatchers.Main) {
            loadUserData()
        }
    }

    suspend fun loadUserData() {
        _userLiveData.value = dataSource.getAllUsers()
    }

    suspend fun insert() {
        if (dataSource.getUser() == null) {
            for (user in userData.userList)
                dataSource.insert(user)
        }
    }

    suspend fun getAll(): List<User> {
        return dataSource.getAllUsers()
    }

    fun getAllLivaData() :  LiveData<List<User>>{
        return dataSource.getAllUsersLiveData()
    }
}