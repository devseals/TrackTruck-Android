package com.example.tracktruck.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.tracktruck.R
import com.example.tracktruck.activities.ui.main.SectionsPagerAdapter
import com.example.tracktruck.activities.ui.main.SectionsPagerAdapter2
import com.example.tracktruck.fragments.ReviewsFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_truck_view.*



class FoodTruckActivity : AppCompatActivity(){

    private var latitude : Double = 0.0
    private var longitude : Double = 0.0
    private var foodtruckName : String = ""
    private var foodtruckId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_truck_view)
        intent?.extras?.apply {

            foodtruckName = getString("name")
            latitude = getDouble("latitude")
            longitude = getDouble("longitude")
            foodTypeViewText.text=getString("food_type")
            avgCostViewText.text="S/ " + getDouble("avg_price").toString()
            foodtruckId= getInt("foodtruck_id")

        }

        setSupportActionBar(toolbar2)
        val actionBar = supportActionBar
        actionBar!!.title = foodtruckName
    }

    fun location()
    {
        val intent = Intent(this,FoodTruckMapAcitivity::class.java)
        intent.putExtra("latitude", foodtruckId)
        intent.putExtra("longitude", foodtruckId)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.navigation2, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.location -> {
                location()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    public fun getFoodTruckId(): Int {
        return foodtruckId
    }
}