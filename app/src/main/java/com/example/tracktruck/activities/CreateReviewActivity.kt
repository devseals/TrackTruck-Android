package com.example.tracktruck.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tracktruck.R
import androidx.appcompat.app.AppCompatActivity
import com.example.tracktruck.services.FoodtrucksService
import kotlinx.android.synthetic.main.activity_create_review.*

class CreateReviewActivity : AppCompatActivity() {

    private var latitude : Double = 0.0
    private var longitude : Double = 0.0
    private var foodtruckName : String = ""
    private var foodtruckId : Int = 0
    private var phoneNumber : String = ""
    private var price : Double = 0.0
    private var type : String = ""
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

            val bundle = Bundle()
              val intent = Intent(this, MainActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            Toast.makeText(this,"Se agregó review exitosamente",Toast.LENGTH_LONG).show()
    }
}