package com.hfad.allmusic.data.repository

import com.hfad.allmusic.data.remote.ApiMusicInterface
import com.hfad.allmusic.data.remote.dto.DataDto
import com.hfad.allmusic.data.remote.dto.MainDataDto
import com.hfad.allmusic.domain.repository.SongRepository
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val api: ApiMusicInterface
) : SongRepository {

    override suspend fun getSongByName(name: String): MainDataDto {

        return api.getSongByName(name)

    }
}