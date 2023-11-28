package com.hfad.allmusic.presentation.search_screen

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.hfad.allmusic.R
import com.hfad.allmusic.databinding.ListSearchItemBinding
import com.hfad.allmusic.domain.model.Data
import com.squareup.picasso.Picasso


class SearchAdapter(private val context: Context) :
    RecyclerView.Adapter<SearchAdapter.SearchHolder>() {

    var items: List<Data> = arrayListOf()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()

        }

    class SearchHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ListSearchItemBinding.bind(item)
        fun bind(song: Data, context: Context) = with(binding) {

            Picasso.get().load("https:" + song.imageCover.cover).into(imageCover)
            titleView.text = song.title
            val mediaPlayer = MediaPlayer.create(context, song.preview.toUri())

            btnPlay.setOnClickListener {
                mediaPlayer.start()
            }

            btnPause.setOnClickListener {
                mediaPlayer.stop()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_search_item, parent, false)

        return SearchHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        val item = items[position]
        holder.bind(item, context)
    }
}