package com.anthonyyoab.androdev.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.anthonyyoab.androdev.R
import com.anthonyyoab.androdev.databinding.ActivityHomeBinding
import com.anthonyyoab.androdev.ui.fragment.ApplicationFragment
import com.anthonyyoab.androdev.ui.fragment.HomeFragment
import com.anthonyyoab.androdev.ui.fragment.NewsFragment
import com.anthonyyoab.androdev.ui.fragment.ProfileFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(R.id.container, HomeFragment.newInstance("",""))

        binding.bottomNav.setOnItemReselectedListener {
            when(it.itemId){

                R.id.menu_application -> {
                    showFragment(R.id.container, ApplicationFragment.newInstance("",""))
                }

                R.id.menu_home -> {
                    showFragment(R.id.container, HomeFragment.newInstance("",""))
                }


                R.id.menu_profile -> {
                    showFragment(R.id.container, ProfileFragment.newInstance("",""))
                }

                R.id.menu_news -> {
                    showFragment(R.id.container, NewsFragment.newInstance("",""))
                }
            }
            true
        }
    }

    fun showFragment(id: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }
}