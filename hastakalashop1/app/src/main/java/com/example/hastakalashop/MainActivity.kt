package com.example.hastakalashop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hastakalashop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as androidx.navigation.fragment.NavHostFragment
        val navController = navHostFragment.navController
        
        // Explicitly setup with NavController to ensure backstack management
        navView.setupWithNavController(navController)

        // Ensure the correct menu item is selected when navigating manually
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> navView.menu.findItem(R.id.navigation_home)?.isChecked = true
                R.id.navigation_categories -> navView.menu.findItem(R.id.navigation_categories)?.isChecked = true
                R.id.navigation_wishlist -> navView.menu.findItem(R.id.navigation_wishlist)?.isChecked = true
                R.id.navigation_profile -> navView.menu.findItem(R.id.navigation_profile)?.isChecked = true
            }
        }
    }
}
