package com.example.tracktruck.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tracktruck.R
import com.example.tracktruck.services.*
import kotlinx.android.synthetic.main.activity_owner_register.*
import kotlinx.android.synthetic.main.activity_user_register.*
import kotlinx.android.synthetic.main.fragment_user_login.*

class UserRegisterActivity : AppCompatActivity() {
    val authService = AuthenticationService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        registerUserButton.setOnClickListener { view->
            registerUser(view)
        }
    }


    fun registerUser(view: View){
        authService.registerUser(
            view.context,
            userNameTxt.editText?.text.toString(),
            userRegisterUserTxt.editText?.text.toString(),
            userPhoneTxt.editText?.text.toString(),
            userRegisterPassTxt.editText?.text.toString())

        val intent = Intent(this,LoginTabActivity::class.java)
        startActivity(intent)
        Toast.makeText(this,"Se registro exitosamente", Toast.LENGTH_LONG).show()
    }
}
