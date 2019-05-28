package com.example.tracktruck.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tracktruck.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class FoodTruckMapAcitivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var latitude : Double = 0.0
    private var longitude : Double = 0.0
    private var foodtruckName : String = ""
    private var foodtruckId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_truck_map_acitivity)
        intent?.extras?.apply {
            foodtruckName = getString("name")
            latitude = getDouble("latitude")
            longitude = getDouble("longitude")
        }
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setTitle("Ubicado en:")
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val location = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(location).title("Marcador en $foodtruckName"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)

        val zoom = CameraUpdateFactory.zoomTo(15f)

        mMap.animateCamera(zoom)

        mMap.isTrafficEnabled =  true
        mMap.isIndoorEnabled =   true
        mMap.isBuildingsEnabled = true
        mMap.uiSettings.isZoomControlsEnabled  = true
    }
}
