package com.example.tracktruck.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.tracktruck.R
import com.example.tracktruck.adapters.FoodTruckRecycleAdapter
import com.example.tracktruck.models.Foodtruck
import com.example.tracktruck.services.FoodtrucksService
import kotlinx.android.synthetic.main.fragment_food_trucks.*
import java.util.ArrayList


class FoodtrucksFragment : Fragment() {

    var trucks = ArrayList<Foodtruck>()
    val foodtruckService = FoodtrucksService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_food_trucks, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val listener = object : TrucksDownloaded{
            override fun success(success: Boolean) {
                if (success){
                    setUpRecyler()
                }
            }
        }
        setUpRecyler()
        trucks=foodtruckService.downloadFoodtrucks(view.context, listener)

    }

    fun setUpRecyler(){
        foodtruckList.apply {
            foodtruckList.adapter = FoodTruckRecycleAdapter(trucks)
            foodtruckList.layoutManager= LinearLayoutManager(this.context)
            foodtruckList.setHasFixedSize(true)
        }
    }

    interface TrucksDownloaded{

        fun success(success: Boolean)

    }
}
