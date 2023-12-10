package com.example.onelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.onelab.data.Dataset
import com.example.onelab.databinding.ActivityMainBinding
import com.example.viewpagersample.transformers.DefaultPageTransformer
import com.example.viewpagersample.transformers.DepthPageTransformer
import com.example.viewpagersample.transformers.ZoomOutPageTransformer
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val cityCollectionAdapter = CityCollectionAdapter(this)
        viewPager = binding.viewPager
        viewPager.adapter = cityCollectionAdapter
        viewPager.setPageTransformer(DepthPageTransformer())

        val tabLayout = binding.tabLayout

        TabLayoutMediator(tabLayout, viewPager, true)
        { tab, position ->
            tab.text = Dataset.cities[position].cityName
        }.attach()


    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    //добавление меню выбора красивых переходов при пролистывании страниц пейджер
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.select_transformer_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            //пролистывание с всплыванием из под текущей картинкы
            R.id.action_depth -> {
                viewPager.setPageTransformer(DepthPageTransformer())
                true
            }
            //пролистывание с увеличением фрагмента
            R.id.action_zoom_out -> {
                viewPager.setPageTransformer(ZoomOutPageTransformer())
                true
            }

            R.id.action_default -> {
                viewPager.setPageTransformer(DefaultPageTransformer())
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}