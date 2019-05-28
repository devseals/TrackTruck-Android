package com.example.tracktruck.fragments


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.tracktruck.R
import com.example.tracktruck.activities.AdministrativeActivity
import com.example.tracktruck.activities.CreateReviewActivity
import com.example.tracktruck.activities.FoodTruckActivity
import com.example.tracktruck.activities.LoginTabActivity
import com.example.tracktruck.adapters.ReviewRecycleAdapter
import com.example.tracktruck.models.Review
import com.example.tracktruck.services.*
import kotlinx.android.synthetic.main.activity_reviews.*
import kotlinx.android.synthetic.main.food_truck_view.*


class ReviewsFragment : Fragment() {

    private var foodtruckId: Int = 0
    private var reviews = ArrayList<Review>()
    val foodtruckService = FoodtrucksService()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val listener = object : ReviewsDownloaded {
            override fun success(success: Boolean) {
                if (success){
                    setUpRecycler()
                }
            }
        }

        activity?.intent?.extras?.apply{
            foodtruckId= getInt("foodtruck_id")
        }

        reviews = foodtruckService.downloadReviews(context,foodtruckId, listener)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener { view ->
            if(DataServiceU.authToken=="") {
                startActivity(Intent(view.context, LoginTabActivity::class.java))
            }else if(DataServiceU.authToken!=""){
                val intent2 = Intent(context, CreateReviewActivity::class.java)
                intent2.putExtra("foodtruckId", foodtruckId)
                startActivity(intent2)
            }
        }
    }
    interface ReviewsDownloaded{

        fun success(success: Boolean)

    }

    fun setUpRecycler(){
        reviewList.apply {
            reviewList.adapter = ReviewRecycleAdapter(reviews)
            reviewList.layoutManager = LinearLayoutManager(this.context)
            reviewList.setHasFixedSize(true)
        }
    }

}
