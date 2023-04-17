package com.example.movieapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.movieapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        showFragment(HomeFragment())
        initViews()
    }

    private fun initViews() {
        binding.BottomNavigationView.setOnItemSelectedListener {
            if (it.itemId ==R.id.home) {
                showFragment(HomeFragment())
            } else if (it.itemId == R.id.search) {
                showFragment(SearchFragment())

            } else if (it.itemId == R.id.bookmarks) {
                showFragment(WatchListFragment())

            } else if (it.itemId == R.id.movie) {
                showFragment(BrowseFragment())

            }

            // make item selected
            return@setOnItemSelectedListener true
        }
    }
    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }
}