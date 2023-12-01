package com.hfad.allmusic.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hfad.allmusic.R
import com.hfad.allmusic.databinding.MainActivityBinding
import com.hfad.allmusic.presentation.search_screen.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, SearchFragment())
                .commit()
        }


    }



}