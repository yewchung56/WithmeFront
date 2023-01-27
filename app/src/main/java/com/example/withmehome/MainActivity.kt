package com.example.withmehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.withmehome.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }
    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅
        var viewPager2Adatper = ViewPager2Adapter(this)
        viewPager2Adatper.addFragment(TotalFragment())
        viewPager2Adatper.addFragment(StudyFragment())
        viewPager2Adatper.addFragment(SportFragment())
        viewPager2Adatper.addFragment(HobbyFragment())
        viewPager2Adatper.addFragment(TravelFragment())
        viewPager2Adatper.addFragment(ExtraFragment())

        //Adapter 연결
        binding.pager.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "전체"
                1 -> tab.text = "스터디"
                2 -> tab.text = "운동"
                3 -> tab.text = "취미"
                4 -> tab.text = "여행"
                5 -> tab.text = "기타"
            }
        }.attach()
    }
}
