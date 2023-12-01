package com.hfad.allmusic.data.remote.dto

import com.hfad.allmusic.domain.model.Album

data class AlbumDto(
    val cover: String,
    val cover_big: String,
    val cover_medium: String,
    val cover_small: String,
    val cover_xl: String,
    val id: Int,
    val md5_image: String,
    val title: String,
    val tracklist: String,
    val type: String
)

fun AlbumDto.toAlbum(): Album {
    return Album(
        cover = cover
    )
}