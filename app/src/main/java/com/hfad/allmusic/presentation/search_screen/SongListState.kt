package com.hfad.allmusic.presentation.search_screen

import com.hfad.allmusic.domain.model.Song

data class SongListState(
    val isLoading: Boolean = false,
    val songs: List<Song> = emptyList(),
    val isError: String = ""
)
