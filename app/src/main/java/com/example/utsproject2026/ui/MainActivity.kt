package com.example.utsproject2026.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.utsproject2026.R
import com.example.utsproject2026.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set fragment default (Daftar Produk)
        if (savedInstanceState == null) {
            loadFragment(ProductListFragment(), getString(R.string.title_product_list))
        }

        // Setup Bottom Navigation Listener
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_products -> {
                    loadFragment(ProductListFragment(), getString(R.string.title_product_list))
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(DeveloperProfileFragment(), getString(R.string.title_profile))
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment, title: String) {
        supportActionBar?.title = title
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}