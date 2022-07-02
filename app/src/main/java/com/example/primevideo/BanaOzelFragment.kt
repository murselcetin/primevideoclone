package com.example.primevideo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.primevideo.databinding.BanaozelRecyclerviewBinding
import com.example.primevideo.databinding.FragmentBanaOzelBinding

class BanaOzelFragment : Fragment() {
    private lateinit var binding: FragmentBanaOzelBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBanaOzelBinding.inflate(inflater, container, false)

        binding.banaOzelRv.setHasFixedSize(true)
        binding.banaOzelRv.layoutManager = LinearLayoutManager(this.context)


        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1, "The Terminal List", "terminallist")
        val f2 = Filmler(2, "The Boyz", "theboys")
        val f3 = Filmler(3, "Bang Bang Baby", "bangbang")
        val f4 = Filmler(4, "Fight Club", "fightclub")
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)

        val BanaOzelAdapter = BanaOzelAdapter(requireContext(), filmlerListesi)
        binding.banaOzelRv.adapter = BanaOzelAdapter

        return binding.root
    }

}