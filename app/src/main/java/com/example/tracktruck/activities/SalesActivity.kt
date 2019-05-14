package com.example.tracktruck.activities

import com.example.tracktruck.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tracktruck.adapters.SaleRecycleAdapter
import com.example.tracktruck.models.Sale
import kotlinx.android.synthetic.main.activity_sales.*
import com.example.tracktruck.services.*

class SalesActivity : AppCompatActivity() {

    val ftServ = FoodtrucksService()
    var sales = ArrayList<Sale>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales)

        if(DataServiceO.isLogged==false){
            startActivity(Intent(this, MainActivity::class.java))
        }

        val listener = object: SalesDownloaded{
            override fun success(success: Boolean) {
                if(success){
                    setUpRecycler()
                }
            }
        }

        sales = ftServ.downloadSales(this,listener)

    }

    interface SalesDownloaded{

        fun success(success: Boolean)

    }

    fun setUpRecycler(){
        salesList.apply {
            salesList.adapter= SaleRecycleAdapter(sales)
            salesList.layoutManager=LinearLayoutManager(this.context)
            salesList.setHasFixedSize(true)
        }
    }
}