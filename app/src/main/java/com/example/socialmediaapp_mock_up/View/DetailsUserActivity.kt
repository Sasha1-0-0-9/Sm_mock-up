package com.example.socialmediaapp_mock_up.View

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.UserViewModel
import java.io.Serializable


class DetailsUserActivity : AppCompatActivity(), Serializable {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_user)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val detailsUserName: TextView = findViewById(R.id.userName)
        val detailsTextStatus: TextView = findViewById(R.id.status)
        val detailsTitle: TextView = findViewById(R.id.userInfo)
        val detailsImage: ImageView = findViewById(R.id.detailsImage)
        val arguments = intent.extras
        val id = arguments?.getInt("id")

        viewModel.loadUserData()

        viewModel.userLiveData.observe(this, Observer {

            detailsUserName.text = it.userList[id!!].name
            detailsTextStatus.text = it.userList[id].hobby
            Glide.with(this).load(it.userList[id].photo).into(detailsImage)
            detailsTextStatus.text = it.userList[id].hobby
            detailsTitle.text = it.userList[id].description
        })
    }
}
