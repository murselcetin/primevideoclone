package com.example.primevideo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.databinding.BanaozelRecyclerviewBinding

class BanaOzelAdapter(var mContext: Context, var filmlerListesi: List<Filmler>) :
    RecyclerView.Adapter<BanaOzelAdapter.cardDesign>() {
    inner class cardDesign(tasarim: BanaozelRecyclerviewBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: BanaozelRecyclerviewBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardDesign {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = BanaozelRecyclerviewBinding.inflate(layoutInflater, parent, false)
        return cardDesign(tasarim)
    }

    override fun onBindViewHolder(holder: cardDesign, position: Int) {
        val film = filmlerListesi[position]
        val t = holder.tasarim

        t.textViewFilmAdi.text = film.filmAdi

        t.ImageViewFilm.setImageResource(
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