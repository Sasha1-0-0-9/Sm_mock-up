package com.example.socialmediaapp_mock_up.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.DetailsUserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable
import kotlin.properties.Delegates


class DetailsUserActivity : AppCompatActivity(), Serializable {
    private lateinit var viewModel: DetailsUserViewModel
    private var id by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_user)
        viewModel = ViewModelProvider(this).get(DetailsUserViewModel::class.java)

        val detailsUserName: TextView = findViewById(R.id.userName)
        val detailsTextStatus: TextView = findViewById(R.id.status)
        val detailsTitle: TextView = findViewById(R.id.userInfo)
        val detailsImage: ImageView = findViewById(R.id.detailsImage)
        id = intent.extras?.getInt("id") ?: 0

        viewModel.loadDetailsUserData(id)

        viewModel.userLiveData.observe(this, Observer {

            detailsUserName.text = it.name
            detailsTextStatus.text = it.hobby
            Glide.with(this).load(it.photo).into(detailsImage)
            detailsTitle.text = it.description
        })
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }
}


