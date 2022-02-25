package com.masterandroid.exammodule5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.masterandroid.exammodule5.R

class ViewPagerAdapter(private val items: ArrayList<com.masterandroid.exammodule5.model.ViewPager2>, private val context: Context) :
    PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.first, container, false)
        view.findViewById<ImageView>(R.id.iv_image).setImageResource(items[position].image)
        view.findViewById<TextView>(R.id.tv_title).setText(items[position].title)
        view.findViewById<TextView>(R.id.tv_des).setText(items[position].desc)

        (container as ViewPager).addView(view)

        return view
    }

    override fun getCount(): Int = items.size


    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }
}