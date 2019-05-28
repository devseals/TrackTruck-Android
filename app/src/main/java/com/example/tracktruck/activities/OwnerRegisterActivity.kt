package com.example.tracktruck.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tracktruck.R
import com.example.tracktruck.services.*
import kotlinx.android.synthetic.main.activity_owner_register.*

class OwnerRegisterActivity : AppCompatActivity() {

    val authService = AuthenticationService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_register)
        ownerRegisterBtn.setOnClickListener {
                view->
            registerOwner(view)
        }
    }
    fun registerOwner(view: View){
        authService.registerOwner(view.context,
            ownerNameTxt.editText?.text.toString(),
            ownerRegisterUserTxt.editText?.text.toString(),
            ownerRegisterPassTxt.editText?.text.toString(),
            ownerRucTxt.editText?.text.toString()
        )
        val intent= Intent(this,LoginTabActivity::class.java)
        startActivity(intent)
        Toast.makeText(this,"Se registro exitosamente", Toast.LENGTH_LONG).show()
    }
}
