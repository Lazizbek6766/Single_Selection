package com.topshiriq.singleselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.topshiriq.singleselection.Adpterlar.ProductAdapter
import com.topshiriq.singleselection.Shablon.Produkt
import com.topshiriq.singleselection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val productAdapter = ProductAdapter(this@MainActivity, Produkt().produkt)
        binding.recycler1.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recycler1.adapter = productAdapter


    }
}