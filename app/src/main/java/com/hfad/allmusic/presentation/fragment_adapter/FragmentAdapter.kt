package com.hfad.allmusic.presentation.fragment_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentManager: FragmentActivity,  private val list:List<Fragment>) : FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]

    }

}