package com.example.nocalories.ui.activity.mainBlock

import android.os.Bundle
import android.view.Menu

import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.ActivityNoCaloriesNavBinding
import com.google.android.material.navigation.NavigationView
import com.pawegio.kandroid.defaultSharedPreferences


class NoCaloriesActivityNav : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoCaloriesNavBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoCaloriesNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNoCaloriesActivityNav.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_no_calories_activity_nav)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_pofel, R.id.nav_slideshow,R.id.recipes2,R.id.recommendations2,R.id.logOutAccount
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }



    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment_content_no_calories_activity_nav)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}