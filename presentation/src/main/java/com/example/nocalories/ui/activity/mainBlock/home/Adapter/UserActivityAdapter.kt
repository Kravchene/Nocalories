package com.example.nocalories.ui.activity.mainBlock.home.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.damain.interfaceListener.UserMetricsClickListener
import com.example.nocalories.databinding.ListUserActivityPerDayBinding
import com.example.damain.models.UserActivity

class UserActivityAdapter(private val userMetricsClickListener: UserMetricsClickListener): RecyclerView.Adapter<UserActivityAdapter.UserActivityHolder>() {

    private val userActivityList:MutableList<UserActivity> =  mutableListOf()

    inner class UserActivityHolder(private val  itemBinding: ListUserActivityPerDayBinding,val listener: UserMetricsClickListener): RecyclerView.ViewHolder(itemBinding.root),
        LifecycleOwner {
        fun bind(userActivity: UserActivity, listener: UserMetricsClickListener) {
            with(itemBinding){
                Name.text=userActivity.name
                image.setImageResource(userActivity.photo)
                itemView.setOnClickListener {
                    listener.onClick(userActivity)
                }
            }
        }

        override val lifecycle: Lifecycle
            get() = TODO("Not yet implemented")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserActivityHolder {
        val itemBinding = ListUserActivityPerDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserActivityHolder(itemBinding, userMetricsClickListener)
    }

    override fun getItemCount(): Int {
        return userActivityList.size
    }

    override fun onBindViewHolder(holder: UserActivityHolder, position: Int) {
        holder.bind(userActivityList[position], userMetricsClickListener )
    }

    fun setData(newList: List<UserActivity>) {
        val diffC = DiffCallback(userActivityList, newList)
        val result = DiffUtil.calculateDiff(diffC)
        userActivityList.clear()
        userActivityList.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    class DiffCallback(private val oldList: List<UserActivity>, private val newList: List<UserActivity>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = oldList[newItemPosition]
            return oldItem == newItem

        }
    }

}