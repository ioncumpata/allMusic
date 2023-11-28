package com.hfad.allmusic.data.remote.dto

import com.hfad.allmusic.domain.model.MainData

data class MainDataDto(
    val `data`: List<DataDto>,
    val next: String,
    val total: Int,

    )
 fun MainDataDto.toMainData(): MainData{
     return MainData(
         data = data.map { it.toData() }
     )
 }