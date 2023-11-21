package com.hfad.allmusic.presentation.playlist_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hfad.allmusic.databinding.FragmentPlaylistBinding

class PlaylistFragment : Fragment() {

    private lateinit var binding: FragmentPlaylistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlaylistBinding.inflate(inflater,container,false)

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = PlaylistFragment()
    }
}