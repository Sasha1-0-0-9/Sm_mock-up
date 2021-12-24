package com.example.socialmediaapp_mock_up.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.Model.UserData
import com.example.socialmediaapp_mock_up.database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsUserViewModel(application: Application) : AndroidViewModel(application) {

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
}