package com.example.tracktruck.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.tracktruck.R
import kotlinx.android.synthetic.main.food_truck_view.*

class FoodTruckActivity : AppCompatActivity(){

    private var latitude : Double = 0.0
    private var longitude : Double = 0.0
    private var foodtruckName : String = ""
    private var foodtruckId : Int = 0
    private var phoneNumber : String = ""
    private val MY_PERMISSIONS_REQUEST_CALL_PHONE = 1


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
            phoneNumber = getString("phone_number")
            phoneNumbertext.text=getString("phone_number")
        }

        setSupportActionBar(toolbar2)
        val actionBar = supportActionBar
        actionBar!!.title = foodtruckName

    }

    fun location()
    {
        val intent = Intent(this,FoodTruckMapAcitivity::class.java)
        intent.putExtra("latitude", latitude)
        intent.putExtra("longitude", longitude)
        intent.putExtra("name", foodtruckName)
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

            R.id.callnumber -> {
                call()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun call(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),MY_PERMISSIONS_REQUEST_CALL_PHONE)
        }
        else
        {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + phoneNumber)
            startActivity(intent)
        }


    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_CALL_PHONE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }


}