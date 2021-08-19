package com.example.songs

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class APIEmulator(){
    val str = """
       {
    "itemListElement": [
        {
            "position": 1,
            "name": "Songsterr",
            "item": "https://www.songsterr.com/"
        },
        {
            "position": 2,
            "name": "The Beatles",
            "item": "https://www.songsterr.com/a/wsa/the-beatles-tabs-a19"
        },
        {
            "position": 3,
            "name": "Come Together Tab",
            "item": "https://www.songsterr.com/a/wsa/the-beatles-come-together-tab-s62923"
        }
    ]
}""".trimIndent()
    val listOfSongs by lazy { getSongList() }

    private fun getSongList():List<Song> {
        val gsonBuilder = GsonBuilder()
        val gson: Gson = gsonBuilder.create()
        val listSongs: SongResult = gson.fromJson(str, SongResult::class.java)
        return listSongs.itemListElement
    }

}