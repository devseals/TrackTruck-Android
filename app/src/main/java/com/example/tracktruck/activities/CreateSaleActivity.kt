package com.example.tracktruck.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tracktruck.R
import com.example.tracktruck.services.FoodtrucksService
import kotlinx.android.synthetic.main.activity_create_sale.*

class CreateSaleActivity : AppCompatActivity() {

    val ftServ = FoodtrucksService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_sale)

        addSaleBtn.setOnClickListener {
                view->createSale(view)
        }
    }

    fun createSale(view: View){
        ftServ.createSale(view.context, saleRegistryAmount?.editText?.text.toString().toDouble(),
            saleRegistryContent?.editText?.text.toString())
        startActivity(Intent(view.context, MainActivity::class.java))
    }

}
