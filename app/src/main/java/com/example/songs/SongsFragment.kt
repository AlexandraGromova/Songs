package com.example.songs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SongsFragment : Fragment(R.layout.songs_fragment){
    private lateinit var songsRecyclerView: RecyclerView
    val viewModelsSongs: ViewModelsSongs by lazy {
        ViewModelProvider(this)[ViewModelsSongs::class.java]
    }
    private var adapter: SongAdapter? = SongAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.songs_fragment, container, false)
        songsRecyclerView = view.findViewById(R.id.songs_fragment) as RecyclerView
        songsRecyclerView.layoutManager = LinearLayoutManager(context)
        songsRecyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelsSongs.songs.observe(viewLifecycleOwner,{ Log.d(TAG, it.toString()) } )
    }

    class SongAdapter(val songs: List<Song>): RecyclerView.Adapter<SongAdapter.SongHolder>(){

        class SongHolder(view: View) : RecyclerView.ViewHolder(view){
            val nameTextView : TextView = itemView.findViewById(R.id.name_song)
            val itemTextView : TextView = itemView.findViewById(R.id.item_song)
            val positionTextView : TextView = itemView.findViewById(R.id.position_song)
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SongHolder {
            val  view = LayoutInflater.from(viewGroup.context).inflate(R.layout.song_item_recycler_view,viewGroup,false)
            return SongHolder(view)
        }

        override fun onBindViewHolder(holder: SongHolder, position: Int) {
            val song = songs[position]
        }

        override fun getItemCount() = songs.size
        }
}
