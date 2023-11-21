package com.hfad.allmusic.domain.model

import com.hfad.allmusic.data.remote.dto.ArtistDto

data class Data(
    val id: Long,
    val artist: ArtistDto,
    val duration: Int,
    val preview: String
)
