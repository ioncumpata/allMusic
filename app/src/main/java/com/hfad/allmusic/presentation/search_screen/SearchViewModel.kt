package com.hfad.allmusic.presentation.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.allmusic.common.Resource
import com.hfad.allmusic.domain.use_case.GetSongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSongUseCase: GetSongUseCase
):ViewModel() {
    private val _state = MutableStateFlow(SongListState())
    val state: StateFlow<SongListState> = _state


    fun getSongs(name: String) = viewModelScope.launch(Dispatchers.IO) {
        getSongUseCase(name).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SongListState(songs = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = SongListState(
                        isError = result.message ?: "An error occur"
                    )

                }
                is Resource.Loading -> {
                    _state.value = SongListState(isLoading = true)
                }
            }
        }
    }
}