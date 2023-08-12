package com.example.nocalories.ui.activity.mainBlock.home.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nocalories.ui.activity.mainBlock.home.AddMeal
import com.example.nocalories.ui.activity.mainBlock.home.HomeFragment
import com.example.nocalories.ui.activity.mainBlock.ui.GeneralStatistics


class FragmentPageAdapter(fragmentActivity: HomeFragment) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            AddMeal()
        else
            GeneralStatistics()
    }
}