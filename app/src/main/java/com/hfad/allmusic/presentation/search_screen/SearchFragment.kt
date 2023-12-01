package com.hfad.allmusic.presentation.search_screen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.allmusic.common.Resource
import com.hfad.allmusic.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.Duration
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()

    @Inject
    lateinit var adapter: SearchAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



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

                withContext(Dispatchers.Main) {

                    if (value.isLoading) {
                        binding.progressBar.visibility = View.VISIBLE
                    } else {

                        if (value.isError.isNotBlank()) {
                            Toast.makeText(requireContext(), value.isError, Toast.LENGTH_LONG)
                                .show()
                        } else {

                            adapter.items = value.songs?.data ?: emptyList()
                            hideKeyboard(binding.searchView)
                            binding.progressBar.visibility = View.GONE
                        }


                    }
                }
            }

        }


    }
    private fun hideKeyboard(view: View) {
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    companion object {

        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}

