package com.example.socialmediaapp_mock_up.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData

class UserViewModel : ViewModel() {

    val userData: UserData = UserData()

    var userLiveData = MutableLiveData<UserData>()

    fun loadUserData(){
        userLiveData.value = userData
    }

}