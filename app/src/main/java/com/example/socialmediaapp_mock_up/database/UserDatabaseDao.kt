package com.example.socialmediaapp_mock_up.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.socialmediaapp_mock_up.Model.User

@Dao
interface UserDatabaseDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM users_database")
    suspend fun getAllUsers() : List<User>

    @Query("SELECT * from users_database WHERE id = :key")
    suspend fun get(key: Int): User?

    @Query("SELECT * FROM users_database LIMIT 1")
    suspend fun getUser() : User?

    @Query("SELECT * FROM users_database")
    fun getAllUsersLiveData() : LiveData<List<User>>

    @Query("SELECT COUNT(*) FROM users_database")
    suspend fun size() : Int
}