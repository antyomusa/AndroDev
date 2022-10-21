package com.anthonyyoab.androdev.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anthonyyoab.androdev.R
import com.anthonyyoab.androdev.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnNews.setOnClickListener{
            val intent = Intent(this@LoginActivity, RandomNewsActivity::class.java)
            startActivity(intent)
        }

        binding.btnRandomNews.setOnClickListener {
            val intent = Intent(this@LoginActivity, RandomNewsActivities::class.java)
            startActivity(intent)
        }
    }
}