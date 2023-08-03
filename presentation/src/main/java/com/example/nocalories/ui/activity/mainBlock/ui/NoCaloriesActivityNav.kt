package com.example.nocalories.ui.activity.mainBlock.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.ActivityNoCaloriesNavBinding
import com.example.nocalories.ui.activity.registrationBlock.Registration_or_Login
import com.google.android.material.navigation.NavigationView
import com.pawegio.kandroid.defaultSharedPreferences

class NoCaloriesActivityNav : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoCaloriesNavBinding
    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoCaloriesNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNoCaloriesActivityNav.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        val navController =
            findNavController(R.id.nav_host_fragment_content_no_calories_activity_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.recipes -> startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=99")
                    )
                )

                R.id.log_out_account -> {
                    val prefs = defaultSharedPreferences
                    prefs.edit {
                        putBoolean("CHECK", false)
                    }
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, Registration_or_Login()).commit()
                }

                R.id.recommendations -> startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://medartby.ru/blog/stati-o-zdorovom-obraze-zhizni/26-sovetov-dlya-pokhudeniya-kotorye-realno-rabotayut/")
                    )
                )
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.no_calories_activity_nav, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment_content_no_calories_activity_nav)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}