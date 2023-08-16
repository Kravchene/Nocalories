package com.example.nocalories.ui.activity.mainBlock.home.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.damain.interfaceListener.MealClickListener
import com.example.damain.interfaceListener.UserMetricsClickListener
import com.example.damain.models.Meal
import com.example.damain.models.UserActivity
import com.example.nocalories.R
import com.example.nocalories.databinding.ListFoodCatalogBinding
import com.example.nocalories.databinding.ListUserActivityPerDayBinding

class MealAdapter(private val mealClickListener: MealClickListener):RecyclerView.Adapter<MealAdapter.MealAdapterHolder>() {

    private val mealList:MutableList<Meal> =  mutableListOf()

    inner class MealAdapterHolder(private val  itemBinding: ListFoodCatalogBinding, val listener: MealClickListener): RecyclerView.ViewHolder(itemBinding.root),
        LifecycleOwner {
        fun bind(meal: Meal, listener: MealClickListener) {
            with(itemBinding){
                Name.text=meal.name
                Glide.with(image.context).load(meal.photo).placeholder(R.drawable.bez_fona_3).error(R.drawable.bez_fona_3).into(image)
                calories.text=meal.calories.toString()
                Fats.text=meal.fats.toString()
                Fiber.text=meal.fiber.toString()
                Carbohydrates.text=meal.carbohydrates.toString()
                Squirrels.text=meal.squirrels.toString()
                itemView.setOnClickListener {
                    listener.onClick(meal)
                }
            }
        }

        override val lifecycle: Lifecycle
            get() = TODO("Not yet implemented")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealAdapterHolder {
        val itemBinding = ListFoodCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealAdapterHolder(itemBinding, mealClickListener)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: MealAdapterHolder, position: Int) {
        holder.bind(mealList[position], mealClickListener )
    }

    fun setData(newList: List<Meal>) {
        val diffC = DiffCallback(mealList, newList)
        val result = DiffUtil.calculateDiff(diffC)
        mealList.clear()
        mealList.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    class DiffCallback(private val oldList: List<Meal>, private val newList: List<Meal>) : DiffUtil.Callback() {

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