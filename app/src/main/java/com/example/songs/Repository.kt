package com.example.songs

class Repository(private val apiEmulator: APIEmulator) {
    fun getSongList(): List<Song> = apiEmulator.listOfSongs
}