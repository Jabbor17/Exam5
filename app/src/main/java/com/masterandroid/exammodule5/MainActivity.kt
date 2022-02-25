package com.masterandroid.exammodule5

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.afollestad.viewpagerdots.DotsIndicator
import com.masterandroid.exammodule5.adapter.ViewPagerAdapter
import com.masterandroid.exammodule5.model.ViewPager2


class MainActivity : AppCompatActivity() {
    lateinit var viewPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {


        viewPager = findViewById(R.id.viewPager)
       val dots:DotsIndicator = findViewById(R.id.dots)
        val pagers:ArrayList<ViewPager2> = ArrayList()
        pagers.add(ViewPager2(R.drawable.ic_baseline_favorite_border_24,"Saved Favorite","Save your favorite listings"))
        pagers.add(ViewPager2(R.drawable.ic_baseline_favorite_border_24,"Saved Favorite","Save your favorite listings"))
        pagers.add(ViewPager2(R.drawable.ic_baseline_favorite_border_24,"Saved Favorite","Save your favorite listings"))
        pagers.add(ViewPager2(R.drawable.ic_baseline_favorite_border_24,"Saved Favorite","Save your favorite listings"))
        pagers.add(ViewPager2(R.drawable.ic_baseline_favorite_border_24,"Saved Favorite","Save your favorite listings"))

        viewPager.adapter = ViewPagerAdapter(pagers, this)
        dots.attachViewPager(viewPager)

        val tv_next = findViewById<TextView>(R.id.tv_next)
        tv_next.setOnClickListener{
            openHomeActivity()
        }
    }

    private fun openHomeActivity() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
    class HelperActivity : Activity() {
        var prefs: SharedPreferences? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // Perhaps set content view here
            prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE)
        }

        override fun onResume() {
            super.onResume()
            if (prefs!!.getBoolean("firstrun", true)) {
                // Do first run stuff here then set 'firstrun' as false
                //strat  DataActivity beacuase its your app first run
                // using the following line to edit/commit prefs
                prefs!!.edit().putBoolean("firstrun", false).commit()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}