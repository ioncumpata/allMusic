package com.hfad.allmusic.presentation.search_screen

import com.hfad.allmusic.domain.use_case.GetSongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSongUseCase: GetSongUseCase
){

}