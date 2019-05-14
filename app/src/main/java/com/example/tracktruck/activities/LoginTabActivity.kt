package com.example.tracktruck.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.tracktruck.R
import com.example.tracktruck.activities.ui.main.SectionsPagerAdapter
import com.example.tracktruck.services.*

class LoginTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_tab)

        if(DataServiceO.isLogged){
            val intent = Intent(this, AdministrativeActivity::class.java)
            startActivity(intent)
        }
        else
            if(DataServiceE.isLogged){
                val intent = Intent(this, CreateSaleActivity::class.java)
                startActivity(intent)
            }
            else
                if(DataServiceU.isLogged){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }

}