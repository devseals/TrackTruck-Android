package com.example.tracktruck.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tracktruck.R
import com.example.tracktruck.services.*
import kotlinx.android.synthetic.main.activity_create_employee.*

class CreateEmployeeActivity : AppCompatActivity() {

    val authServ = AuthenticationService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_employee)

        button5.setOnClickListener {
                view->
            createEmployee(view)
        }
    }

    fun createEmployee(view: View){
        if(DataServiceO.isLogged) {
            authServ.registerEmployee(
                view.context, employeeName?.editText?.text.toString(),
                employeeUser?.editText?.text.toString(), employeePass?.editText?.text.toString()
            )
            startActivity(Intent(this, AdministrativeActivity::class.java))
            Toast.makeText(this,"Se agregó empleado exitosamente", Toast.LENGTH_LONG).show()
        }else{
            startActivity(Intent(this, LoginTabActivity::class.java))
        }

    }
}