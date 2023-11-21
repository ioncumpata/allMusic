package com.hfad.allmusic.data.remote.dto

data class MainDataDto(
    val data: List<DataDto>,
    val next: String,
    val total: Int,

    )