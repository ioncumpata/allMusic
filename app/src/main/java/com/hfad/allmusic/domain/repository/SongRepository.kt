package com.hfad.allmusic.domain.repository

import com.hfad.allmusic.data.remote.dto.DataDto

interface SongRepository {

    suspend fun getSongByName(name: String): List<DataDto>
}