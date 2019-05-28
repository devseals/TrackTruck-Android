package com.example.tracktruck.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tracktruck.R
import com.example.tracktruck.services.*
import kotlinx.android.synthetic.main.activity_create_food_truck.*

class CreateFoodtruckActivity : AppCompatActivity() {

    val ftService = FoodtrucksService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_food_truck)

        addTruckBtn.setOnClickListener {
                view-> createFoodtruck(view)
        }
    }

    fun createFoodtruck(view: View){

        if(DataServiceO.isLogged) {
            ftService.createTruck(
                view.context,
                truckName.editText?.text.toString(),
                truckType.editText?.text.toString(),
                truckPrice.editText?.text.toString().toDouble(),
                truckLatitude.editText?.text.toString().toDouble(),
                truckLongitude.editText?.text.toString().toDouble(),
                truckPhone.editText?.text.toString()
            )
            startActivity(Intent(view.context, AdministrativeActivity::class.java))
            Toast.makeText(this,"Se agregó foodtruck exitosamente", Toast.LENGTH_LONG).show()
        }else{
            startActivity(Intent(this, LoginTabActivity::class.java))
        }


    }
}
