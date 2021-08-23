package com.example.songs

import org.junit.Assert
import org.junit.Test

class RepositoryTest {
    @Test
    fun compare_responses_APIEmulator_Repository(){
        var apiEmulator = APIEmulator()
        var repository = Repository(apiEmulator)
        var answerAPI = apiEmulator.listOfSongs
        var answerRepo = repository.getSongList()
        Assert.assertEquals(answerAPI, answerRepo)
    }
}