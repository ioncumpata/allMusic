package com.hfad.allmusic.domain.use_case

import com.hfad.allmusic.common.Resource
import com.hfad.allmusic.data.remote.dto.DataDto
import com.hfad.allmusic.data.remote.dto.MainDataDto
import com.hfad.allmusic.data.remote.dto.toData
import com.hfad.allmusic.domain.model.Data
import com.hfad.allmusic.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSongUseCase @Inject constructor(
    private val repository: SongRepository
) {
    operator fun invoke(songName: String): Flow<Resource<List<Data>>> = flow {
        try {

            emit(Resource.Loading())
            val songs = repository.getSongByName(songName).map { it.toData() }
            emit(Resource.Success(songs))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))

        }
    }
}