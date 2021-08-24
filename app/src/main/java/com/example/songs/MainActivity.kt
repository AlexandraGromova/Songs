package com.example.songs


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: ViewModelsSongs by viewModels()
        model.songs.observe(this,{ Log.d(TAG, it.toString()) } )
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SongsFragment>(R.id.songs_fragment)
            }
        }
    }
}