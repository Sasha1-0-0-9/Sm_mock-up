package com.example.socialmediaapp_mock_up.View

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.DetailsUserViewModel
import com.example.socialmediaapp_mock_up.ViewModel.UserViewModel
import java.io.Serializable


class DetailsUserActivity : AppCompatActivity(), Serializable {
    private lateinit var viewModel: DetailsUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_user)

        viewModel = ViewModelProvider(this).get(DetailsUserViewModel::class.java)

        val detailsUserName: TextView = findViewById(R.id.userName)
        val detailsTextStatus: TextView = findViewById(R.id.status)
        val detailsTitle: TextView = findViewById(R.id.userInfo)
        val detailsImage: ImageView = findViewById(R.id.detailsImage)
        val arguments = intent.extras
        val id = arguments?.getInt("id")

        viewModel.loadDetailsUserData(id!!)

        viewModel.userLiveData.observe(this, Observer {

            detailsUserName.text = it.name
            detailsTextStatus.text = it.hobby
            Glide.with(this).load(it.photo).into(detailsImage)
            detailsTitle.text = it.description
        })
    }
}
