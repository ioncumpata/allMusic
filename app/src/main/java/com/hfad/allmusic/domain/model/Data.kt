package com.hfad.allmusic.domain.model

data class Data(
    val id: Long,
    val title: String,
    val duration: Int,
    val preview: String,
    val imageCover: Album
)
