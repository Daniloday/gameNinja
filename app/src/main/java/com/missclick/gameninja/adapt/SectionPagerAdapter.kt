package com.missclick.gameninja.adapt

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.missclick.gameninja.ui.recordsScreen.RecordsScreenFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter(fm: FragmentManager, val secondWeek : Int)
    : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return if(position == 0){
            RecordsScreenFragment()
        } else{
            RecordsScreenFragment()
        }
    }

    override fun getCount(): Int {
        return secondWeek
    }

}