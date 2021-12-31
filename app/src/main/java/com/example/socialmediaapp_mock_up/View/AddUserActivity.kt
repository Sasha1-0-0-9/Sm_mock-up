package com.example.socialmediaapp_mock_up.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.AddUserViewModel
import java.util.*
import kotlin.random.Random.Default.nextInt

class AddUserActivity : AppCompatActivity() {

    private lateinit var viewModel: AddUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this)[AddUserViewModel::class.java]

        val id = viewModel.pridicatedId
        val editUserName: EditText = findViewById(R.id.etName)
        val editOnline: EditText = findViewById(R.id.etOnline)
        val editPhoto: EditText = findViewById(R.id.etPhoto)
        val editDesc: EditText = findViewById(R.id.etDescription)
        val editHobby: EditText = findViewById(R.id.etHobby)

        val btn: Button = findViewById(R.id.btnSaveChanges)
        btn.setOnClickListener {
            val user = User(
                id,
                editUserName.text.toString(),
                editOnline.text.toString(),
                editPhoto.text.toString(),
                editHobby.text.toString(),
                editDesc.text.toString()
            )
            viewModel.insertUser(user)
            val intent = Intent(this, UserListActivity::class.java)
            this.finish()
            startActivity(intent)
        }
    }
}
