package com.anthonyyoab.androdev.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anthonyyoab.androdev.R
import com.anthonyyoab.androdev.databinding.ActivityRandomNewsActivitiesBinding
import com.anthonyyoab.androdev.ui.adapter.NewsAdapter
import com.anthonyyoab.androdev.ui.viewmodel.RandomListNewsViewModel

class RandomNewsActivities : AppCompatActivity() {
    private lateinit var binding: ActivityRandomNewsActivitiesBinding
    private lateinit var adapter: NewsAdapter
    private val viewModel: RandomListNewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomNewsActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idTitles.layoutManager = LinearLayoutManager(this@RandomNewsActivities)

        viewModel.getRandomNewes(10)

        setObserver()
    }

    private fun setObserver() {
        viewModel.getRandomListNewesLiveData().observe(this, {
            if(it.isNotEmpty()){
                adapter = NewsAdapter(it)
                binding.idTitles.adapter = adapter
            } else {
                Toast.makeText(this@RandomNewsActivities, "Empty Data",
                Toast.LENGTH_SHORT).show()
            }
        })
    }
}