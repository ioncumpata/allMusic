package com.hfad.allmusic.data.remote.dto

import com.hfad.allmusic.domain.model.Data

data class DataDto(
    val album: AlbumDto,
    val artist: ArtistDto,
    val duration: Int,
    val explicit_content_cover: Int,
    val explicit_content_lyrics: Int,
    val explicit_lyrics: Boolean,
    val id: Long,
    val link: String,
    val md5_image: String,
    val preview: String,
    val rank: Int,
    val readable: Boolean,
    val title: String,
    val title_short: String,
    val title_version: String,
    val type: String
)

fun DataDto.toData(): Data {
    return Data(
        id = id,
        artist = artist,
        duration = duration,
        preview = preview
    )
}