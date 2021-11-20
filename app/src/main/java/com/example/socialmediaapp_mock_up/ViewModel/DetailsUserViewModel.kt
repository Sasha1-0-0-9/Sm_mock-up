package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData
import com.example.socialmediaapp_mock_up.database.UserDatabase

class DetailsUserViewModel(application: Application) : ViewModel() {

    val userData: UserData = UserData()
    private val _userDetailsLiveData = MutableLiveData<User>()
    val dataSource = UserDatabase.getInstance(application).userDatabaseDao
    val userLiveData: LiveData<User> = _userDetailsLiveData

    fun loadDetailsUserData(id: Int) {
        _userDetailsLiveData.value = dataSource.get(id)
    }
}