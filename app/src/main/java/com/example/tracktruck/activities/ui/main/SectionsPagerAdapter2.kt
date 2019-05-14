package com.example.tracktruck.activities.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tracktruck.R
import com.example.tracktruck.fragments.*

private val TAB_TITLES = arrayOf(
    R.string.tab_text_4,
    R.string.tab_text_5
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter2(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return UserLoginFragment()
            }
            1->{
                return ReviewsFragment()
            }
        }
        return OwnerLoginFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}