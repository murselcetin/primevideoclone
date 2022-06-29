package com.example.primevideo

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        return binding.root
    }

    fun changeColor(){
        when(viewPager.currentItem){
            0->{
                iv1.setBackgroundColor(resources.getColor(R.color.acik_mavi))
                iv2.setBackgroundColor(resources.getColor(R.color.white))
                iv3.setBackgroundColor(resources.getColor(R.color.white))
            }
            1->{
                iv1.setBackgroundColor(resources.getColor(R.color.white))
                iv2.setBackgroundColor(resources.getColor(R.color.acik_mavi))
                iv3.setBackgroundColor(resources.getColor(R.color.white))
            }
            2->{
                iv1.setBackgroundColor(resources.getColor(R.color.white))
                iv2.setBackgroundColor(resources.getColor(R.color.white))
                iv3.setBackgroundColor(resources.getColor(R.color.acik_mavi))
            }
        }
    }
}