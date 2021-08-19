package com.example.songs

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Test

import org.junit.Assert.*

class APIEmulatorTest {
    @Test
    fun checking_size_ofObjects() {
        var apiEmulator = APIEmulator()
        var sizeSongsInList = apiEmulator.listOfSongs.size
        assertEquals(3, sizeSongsInList)
    }

    @Test
    fun name_object2_is_TheBeatles() {
        var apiEmulator = APIEmulator()
        var nameObj2 = apiEmulator.listOfSongs[1].name
        assertEquals("The Beatles", nameObj2)
    }
}