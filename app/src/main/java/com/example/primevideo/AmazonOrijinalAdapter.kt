package com.example.primevideo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.databinding.FilmRecyclerviewBinding

class AmazonOrijinalAdapter (var mContext: Context,var filmlerListesi: List<Filmler>) : RecyclerView.Adapter<AmazonOrijinalAdapter.cardDesign>() {
    inner class cardDesign(tasarim: FilmRecyclerviewBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: FilmRecyclerviewBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardDesign {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = FilmRecyclerviewBinding.inflate(layoutInflater, parent, false)
        return cardDesign(tasarim)
    }

    override fun onBindViewHolder(holder: cardDesign, position: Int) {
        val film = filmlerListesi[position]
        val t = holder.tasarim

        t.imageViewResim.setImageResource(
            mContext.resources.getIdentifier(
                film.filmResimAdi,
                "drawable",
                mContext.packageName
            )
        )
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}