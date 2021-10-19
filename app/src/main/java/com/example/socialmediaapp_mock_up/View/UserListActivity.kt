package com.example.socialmediaapp_mock_up.View

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.net.Uri.decode
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.UserViewModel
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.stream.Stream

class UserListActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val user1: LinearLayout = findViewById(R.id.layout1)
        val user2: LinearLayout = findViewById(R.id.layout2)
        val user3: LinearLayout = findViewById(R.id.layout3)
        val user4: LinearLayout = findViewById(R.id.layout4)
        val user5: LinearLayout = findViewById(R.id.layout5)
        val user6: LinearLayout = findViewById(R.id.layout6)
        val user7: LinearLayout = findViewById(R.id.layout7)

        val userName1: TextView = findViewById(R.id.userName1)
        val userName2: TextView = findViewById(R.id.userName2)
        val userName3: TextView = findViewById(R.id.userName3)
        val userName4: TextView = findViewById(R.id.userName4)
        val userName5: TextView = findViewById(R.id.userName5)
        val userName6: TextView = findViewById(R.id.userName6)
        val userName7: TextView = findViewById(R.id.userName7)

        val userPhoto1: ImageView = findViewById(R.id.profile_image1)
        val userPhoto2: ImageView = findViewById(R.id.profile_image2)
        val userPhoto3: ImageView = findViewById(R.id.profile_image3)
        val userPhoto4: ImageView = findViewById(R.id.profile_image4)
        val userPhoto5: ImageView = findViewById(R.id.profile_image5)
        val userPhoto6: ImageView = findViewById(R.id.profile_image6)
        val userPhoto7: ImageView = findViewById(R.id.profile_image7)

        viewModel.loadUserData()

        viewModel.userLiveData.observe(this, Observer {

            user1.setOnClickListener { onClick(0) }
            userName1.text = it.userList[0].name
            Glide.with(this).load(it.userList[0].photo).into(userPhoto1)

            user2.setOnClickListener { onClick(1) }
            userName2.text = it.userList[1].name
            Glide.with(this).load(it.userList[1].photo).into(userPhoto2)

            user3.setOnClickListener { onClick(2) }
            userName3.text = it.userList[2].name
            Glide.with(this).load(it.userList[2].photo).into(userPhoto3)

            user4.setOnClickListener { onClick(3) }
            userName4.text = it.userList[3].name
            Glide.with(this).load(it.userList[3].photo).into(userPhoto4)

            user5.setOnClickListener { onClick(4) }
            userName5.text = it.userList[4].name
            Glide.with(this).load(it.userList[4].photo).into(userPhoto5)

            user6.setOnClickListener { onClick(5) }
            userName6.text = it.userList[5].name
            Glide.with(this).load(it.userList[5].photo).into(userPhoto6)

            user7.setOnClickListener { onClick(6) }
            userName7.text = it.userList[6].name
            Glide.with(this).load(it.userList[6].photo).into(userPhoto7)
        })
    }

    private fun onClick(index: Int) {
        val intent = Intent(this, DetailsUserActivity::class.java)
        intent.putExtra("id", index)
        startActivity(intent)
    }
}


