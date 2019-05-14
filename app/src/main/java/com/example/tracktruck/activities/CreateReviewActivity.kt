package com.example.tracktruck.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.tracktruck.R
import androidx.appcompat.app.AppCompatActivity
import com.example.tracktruck.services.FoodtrucksService
import kotlinx.android.synthetic.main.activity_create_review.*

class CreateReviewActivity : AppCompatActivity() {

    var foodtruckId:Int = 0
    val ftServ = FoodtrucksService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_review)

        foodtruckId= intent.getIntExtra("foodtruckId",0)

        button4.setOnClickListener {
                view->
            createReview(view)
        }
    }

    fun createReview(view: View){
        ftServ.createReview(view.context,
            foodtruckId,reviewContent.editText?.text.toString(),
            reviewTitle.editText?.text.toString())
        val intent= Intent(view.context,FoodTruckActivity::class.java)
        startActivity(intent)
    }
}