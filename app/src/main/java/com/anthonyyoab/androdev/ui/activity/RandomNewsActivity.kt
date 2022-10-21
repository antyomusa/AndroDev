package com.anthonyyoab.androdev.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.anthonyyoab.androdev.databinding.ActivityRandomNewsBinding
import com.anthonyyoab.androdev.ui.viewmodel.RandomNewsViewModel
import com.bumptech.glide.Glide

class RandomNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomNewsBinding
    private val viewModel: RandomNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRandomNews()

        setObserver()
    }

    private fun setObserver() {
        viewModel.getRandomNewsLiveData().observe(this, Observer {
            Glide.with(this@RandomNewsActivity).load(it.imageLink).into(binding.idNews)

            binding.idTitle.text = it.name
            binding.idHabitat.text = "Habibat type = ${it.habitat}"
            binding.idAnimalType.text = "News type = ${it.animalType}"
        })
    }
}