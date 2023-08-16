package com.example.nocalories.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.damain.models.UserActivity

class ActivityViewModel :ViewModel() {
    private var myData: UserActivity? = null

    fun setMyData(data: UserActivity) {
        myData = data
    }

    fun getMyData(): UserActivity? {
        return myData
    }
}
