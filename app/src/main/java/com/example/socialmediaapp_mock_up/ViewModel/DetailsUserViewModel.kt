package com.example.socialmediaapp_mock_up.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData

class DetailsUserViewModel: ViewModel() {

    val userData: UserData = UserData()
    private val _userDetailsLiveData = MutableLiveData<User>()
    val userLiveData : LiveData<User> = _userDetailsLiveData

    fun loadDetailsUserData(id: Int){
        _userDetailsLiveData.value = userData.userList[id]
    }
}