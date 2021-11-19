package com.example.socialmediaapp_mock_up.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "users_database")
data class User(

    @PrimaryKey()
    val id : Int,

    @ColumnInfo(name = "user_name")
    val name: String,

    @ColumnInfo(name = "user_online")
    val online: String,

    @ColumnInfo(name = "user_photo")
    val photo: String,

    @ColumnInfo(name = "user_hobby")
    val hobby: String,

    @ColumnInfo(name = "user_about")
    val description: String)