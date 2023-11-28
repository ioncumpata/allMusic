package com.hfad.allmusic.presentation.search_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.allmusic.common.Resource
import com.hfad.allmusic.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: SearchAdapter
    private val viewModel: SearchViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SearchAdapter(requireContext())

        val layoutManager = LinearLayoutManager(context)
        binding.rcView.layoutManager = layoutManager
        binding.rcView.adapter = adapter



        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(song: String?): Boolean {
                if (song != null) {
                    viewModel.getSongs(song)
                }
                return true
            }

            override fun onQueryTextChange(song: String?): Boolean {
                return true
            }

        })
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.state.collectLatest { value ->

                withContext(Dispatchers.Main){

                    if(value.isLoading){}
                    if (value.isError.isNotBlank()){}
                    else{
                        adapter.items = value.songs.flatMap { it.data }

                    }


                }
            }

        }


    }

    companion object {

        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}

