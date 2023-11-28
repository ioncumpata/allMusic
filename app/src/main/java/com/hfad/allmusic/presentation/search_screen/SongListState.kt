package com.hfad.allmusic.presentation.search_screen

import com.hfad.allmusic.domain.model.Data
import com.hfad.allmusic.domain.model.MainData

data class SongListState(
    val isLoading: Boolean = false,
    val songs: List<MainData> = emptyList(),
    val isError: String = ""
)
