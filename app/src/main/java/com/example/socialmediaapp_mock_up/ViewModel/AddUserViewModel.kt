package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.database.UserDatabase
import kotlinx.coroutines.launch

class AddUserViewModel(application: Application) : AndroidViewModel(application) {

    val dataSource = UserDatabase.getInstance(application).userDatabaseDao
    var pridicatedId = 0
    init {
        viewModelScope.launch {
            pridicatedId = dataSource.size()
        }
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            dataSource.insert(user)
        }
    }
}