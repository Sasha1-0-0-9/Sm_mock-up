package com.example.socialmediaapp_mock_up.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.ViewModel.DetailsUserViewModel
import kotlin.properties.Delegates

class EditProfileActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailsUserViewModel
    private var id by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        viewModel = ViewModelProvider(this).get(DetailsUserViewModel::class.java)

        id = intent.extras?.getInt("id")!!
        val editUserName: EditText = findViewById(R.id.etName)
        val editOnline: EditText = findViewById(R.id.etOnline)
        val editPhoto: EditText = findViewById(R.id.etPhoto)
        val editDesc: EditText = findViewById(R.id.etDescription)
        val editHobby: EditText = findViewById(R.id.etHobby)
        viewModel.loadDetailsUserData(id)

        viewModel.userLiveData.observe(this, Observer {
            editUserName.setText(it.name)
            editOnline.setText(it.online)
            editPhoto.setText(it.photo)
            editDesc.setText(it.description)
            editHobby.setText(it.hobby)
        })

        val btn: Button = findViewById(R.id.btnSaveChanges)
        btn.setOnClickListener {
            val user: User = User(
                id,
                editUserName.text.toString(),
                editOnline.text.toString(),
                editPhoto.text.toString(),
                editHobby.text.toString(),
                editDesc.text.toString()
            )
            viewModel.updateUserInfo(user)
            val intent = Intent(this, UserListActivity::class.java)
            this.finish()
            startActivity(intent)
        }
    }
}