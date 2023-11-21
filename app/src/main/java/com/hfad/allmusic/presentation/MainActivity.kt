package com.hfad.allmusic.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.hfad.allmusic.databinding.ActivityMainBinding
import com.hfad.allmusic.presentation.fragment_adapter.FragmentAdapter
import com.hfad.allmusic.presentation.playlist_screen.PlaylistFragment
import com.hfad.allmusic.presentation.search_screen.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listFragments = listOf(
        SearchFragment.newInstance(),
        PlaylistFragment.newInstance()
    )
    private val tabList = listOf(
        "Search", "Playlist"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        viewPagerInit()
    }


    private fun viewPagerInit() = with(binding) {
        val vP = FragmentAdapter(this@MainActivity as FragmentActivity, listFragments)
        viewPager.adapter = vP

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}