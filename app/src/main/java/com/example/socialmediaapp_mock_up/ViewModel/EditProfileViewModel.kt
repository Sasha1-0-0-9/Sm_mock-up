package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.database.UserDatabase
import kotlinx.coroutines.launch

class EditProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val _userDetailsLiveData = MutableLiveData<User>()
    val dataSource = UserDatabase.getInstance(application).userDatabaseDao
    val userLiveData: LiveData<User> = _userDetailsLiveData

    suspend fun loadDetailsUserData(id: Int) {
        _userDetailsLiveData.value = dataSource.get(id)
    }

    fun init(id: Int) {
        viewModelScope.launch {
            _userDetailsLiveData.value = dataSource.get(id)
        }
    }

    fun updateUserInfo(user: User) {
        viewModelScope.launch {
            dataSource.update(user)
        }
    }
}