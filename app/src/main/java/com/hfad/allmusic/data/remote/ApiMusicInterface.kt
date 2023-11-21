package com.hfad.allmusic.data.remote

import com.hfad.allmusic.data.remote.dto.DataDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiMusicInterface {

    @Headers("X-RapidAPI-Key: f3e937b351msh7645c07e5ecaa81p1ec214jsn4eaa57bdb635",
    "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    suspend fun getSongByName(@Query("q") name: String): List<DataDto>
}