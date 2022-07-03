package com.example.primevideo

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.primevideo.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    private lateinit var viewPager : ViewPager2
    private lateinit var iv1 : ImageView
    private lateinit var iv2 : ImageView
    private lateinit var iv3 : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        viewPager = binding.viewPager
        iv1 = binding.iv1
        iv2 = binding.iv2
        iv3 = binding.iv3

        val images= listOf(R.drawable.viewpager1,R.drawable.viewpager2,R.drawable.viewpager3)
        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback (){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }
        })

        binding.rv.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        binding.rv2.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1, "The Terminal List", "terminallist",2020,122)
        val f2 = Filmler(2, "The Boyz", "theboys",2021,126)
        val f3 = Filmler(3, "Bang Bang Baby", "bangbang",2022,135)
        val f4 = Filmler(4, "The Summer I Turned Pretty", "thesummer",2020,152)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)

        val filmlerListesi2 = ArrayList<Filmler>()
        val fl1 = Filmler(1, "Dayı", "dayi",2020,152)
        val fl2 = Filmler(2, "Sıfır Bir", "sifirbir",2020,152)
        val fl3 = Filmler(3, "Hızlı ve Öfkeli 7", "hizliveofkeli",2020,152)
        val fl4 = Filmler(4, "Fight Club", "fightclub",2020,152)
        filmlerListesi2.add(fl1)
        filmlerListesi2.add(fl2)
        filmlerListesi2.add(fl3)
        filmlerListesi2.add(fl4)

        val AmazonOrijinalAdapter = AmazonOrijinalAdapter(requireContext(), filmlerListesi)
        binding.rv.adapter = AmazonOrijinalAdapter

        val SeslendirmeAdapter = AmazonOrijinalAdapter(requireContext(), filmlerListesi2)
        binding.rv2.adapter = SeslendirmeAdapter

        return binding.root
    }

    fun changeColor(){
        when(viewPager.currentItem){
            0->{
                iv1.setBackgroundColor(resources.getColor(R.color.white))
                iv2.setBackgroundColor(resources.getColor(R.color.gri))
                iv3.setBackgroundColor(resources.getColor(R.color.gri))
            }
            1->{
                iv1.setBackgroundColor(resources.getColor(R.color.gri))
                iv2.setBackgroundColor(resources.getColor(R.color.white))
                iv3.setBackgroundColor(resources.getColor(R.color.gri))
            }
            2->{
                iv1.setBackgroundColor(resources.getColor(R.color.gri))
                iv2.setBackgroundColor(resources.getColor(R.color.gri))
                iv3.setBackgroundColor(resources.getColor(R.color.white))
            }
        }
    }
}