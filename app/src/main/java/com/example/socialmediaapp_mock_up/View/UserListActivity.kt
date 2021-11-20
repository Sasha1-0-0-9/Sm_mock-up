package com.example.socialmediaapp_mock_up.View

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.UserViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val users = listOf<LinearLayout>(
            findViewById(R.id.layout1), findViewById(R.id.layout2),
            findViewById(R.id.layout3), findViewById(R.id.layout4),
            findViewById(R.id.layout5), findViewById(R.id.layout6),
            findViewById(R.id.layout7)
        )

        val userNames = listOf<TextView>(
            findViewById(R.id.userName1), findViewById(R.id.userName2),
            findViewById(R.id.userName3), findViewById(R.id.userName4),
            findViewById(R.id.userName5), findViewById(R.id.userName6),
            findViewById(R.id.userName7)
        )

        val userPhotos = listOf<ImageView>(
            findViewById(R.id.profile_image1), findViewById(R.id.profile_image2),
            findViewById(R.id.profile_image3), findViewById(R.id.profile_image4),
            findViewById(R.id.profile_image5), findViewById(R.id.profile_image6),
            findViewById(R.id.profile_image7)
        )
        viewModel.insert()
        viewModel.loadUserData()
        viewModel.userLiveData.observe(this, Observer {

            for (id in users.indices) {
                users[id].setOnClickListener { onClick(id) }
                userNames[id].text = it[id].name
                Glide.with(this).load(it[id].photo).into(userPhotos[id])
            }
        })
    }

    private fun onClick(index: Int) {
        val intent = Intent(this, DetailsUserActivity::class.java)
        intent.putExtra("id", index)
        startActivity(intent)
    }
}


