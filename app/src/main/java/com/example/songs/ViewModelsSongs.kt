package com.example.songs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelsSongs : ViewModel() {
    val repository = Repository(APIEmulator())
     val songs : MutableLiveData<List<Song>> by lazy {
        MutableLiveData<List<Song>>()
    }
    val song: LiveData<List<Song>> get() = songs

    fun changingSongs() {
        songs.value = repository.getSongList()
    }
}