package com.example.nocalories.ui.activity.mainBlock.ui.home.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nocalories.ui.activity.mainBlock.ui.General_statistics
import com.example.nocalories.ui.activity.mainBlock.ui.home.Add_a_meal
import com.example.nocalories.ui.activity.mainBlock.ui.home.HomeFragment

class FragmentPageAdapter(fragmentActivity: HomeFragment) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            Add_a_meal()
        else
            General_statistics()
    }
}