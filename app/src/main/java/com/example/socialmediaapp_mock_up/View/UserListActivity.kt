package com.example.socialmediaapp_mock_up.View

import UserAdapter
import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.UserViewModel
import com.example.socialmediaapp_mock_up.adapter.OnUserClick

class UserListActivity : AppCompatActivity(), OnUserClick {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val recyclerView: RecyclerView = findViewById(R.id.userList)
        val adapter = UserAdapter(this as OnUserClick)
        recyclerView.adapter = adapter


        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getAllLivaData().observe(this, {
            it?.let {
                adapter.submitList(it)
            }
        })
    }

    override fun onClick(id: Int) {
        val intent = Intent(this, DetailsUserActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}


