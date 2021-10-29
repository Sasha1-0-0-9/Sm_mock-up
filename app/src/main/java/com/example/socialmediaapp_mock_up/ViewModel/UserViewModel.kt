package com.example.socialmediaapp_mock_up.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData

class UserViewModel : ViewModel() {

    val userData: UserData = UserData()

    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    fun loadUserData() {
        _userLiveData.value = userData.userList
    }

}