package com.masterandroid.exammodule5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.masterandroid.exammodule5.fragment.CollectionsFragment
import com.masterandroid.exammodule5.fragment.HomeFragment
import com.masterandroid.exammodule5.fragment.MessagesFragment
import com.masterandroid.exammodule5.fragment.SearchFragment


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
    }

    private fun initViews() {
        val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedLisitener)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment(), "").commit()

    }




    private var navigationItemSelectedLisitener: BottomNavigationView.OnNavigationItemSelectedListener? =
    BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        var selectedFragment:Fragment? = null
        when (menuItem.itemId) {
            R.id.home -> {
                selectedFragment = HomeFragment()


            }
            R.id.collection -> {
               selectedFragment = CollectionsFragment()

            }
            R.id.comment -> {
               selectedFragment = MessagesFragment()

            }
            R.id.search -> {
                selectedFragment = SearchFragment()
            }

        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,selectedFragment!!).commit()
        return@OnNavigationItemSelectedListener true
    }





    }
