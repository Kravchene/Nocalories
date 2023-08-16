package com.example.nocalories.ui.activity.mainBlock.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.damain.interfaceListener.UserMetricsClickListener
import com.example.damain.models.UserActivity
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentUserActivityPerDayBinding
import com.example.nocalories.ui.activity.mainBlock.home.Adapter.UserActivityAdapter
import com.example.nocalories.ui.viewModel.ActivityViewModel
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserActivityPerDay : Fragment(), UserMetricsClickListener {

    lateinit var binding:FragmentUserActivityPerDayBinding
    private lateinit var viewModel: ActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserActivityPerDayBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)
        val adapter = UserActivityAdapter(this@UserActivityPerDay)
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
            recyclerView.setItemViewCacheSize(3)
        }
        val userActivityList:MutableList<UserActivity> =  mutableListOf()
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_1),2))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_2),2))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_3),3))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_4),4))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_5),5))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_6),6))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_7),7))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_8),8))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_9),9))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_10),10))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_11),11))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_12),12))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_13),13))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_14),14))
        userActivityList.add(UserActivity(R.drawable.running,resources.getString(R.string.activity_user_15),15))

        adapter.setData(userActivityList)
    }

    override fun onClick(user: UserActivity) {
        viewModel.setMyData(user)
        findNavController().navigate(R.id.action_userActivityPerDay_to_addActivity)
    }
}