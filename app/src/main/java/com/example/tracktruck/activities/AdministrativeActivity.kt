package com.example.tracktruck.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.tracktruck.R
import kotlinx.android.synthetic.main.activity_administrative.*

class AdministrativeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administrative)

        salesBtn.setOnClickListener {
                view->viewSales()
        }

        truckBtn.setOnClickListener {
                view->addTruck()
        }

        employeeBtn.setOnClickListener {
                view->addEmployee()
        }

    }

    fun viewSales(){
        val intent = Intent(this, SalesActivity::class.java)
        startActivity(intent)
    }

    fun addTruck(){
        val intent = Intent(this, CreateFoodtruckActivity::class.java)
        startActivity(intent)
    }

    fun addEmployee(){
        val intent = Intent(this, CreateEmployeeActivity::class.java)
        startActivity(intent)
    }


}
