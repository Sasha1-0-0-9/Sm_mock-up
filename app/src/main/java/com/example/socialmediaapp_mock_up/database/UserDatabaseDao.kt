package com.example.socialmediaapp_mock_up.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.socialmediaapp_mock_up.Model.User

@Dao
interface UserDatabaseDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM users_database")
    fun getAllUsers() : List<User>

    @Query("SELECT * from users_database WHERE id = :key")
    fun get(key: Int): User?

    @Query("SELECT * FROM users_database LIMIT 1")
    fun getUser() : User?
}