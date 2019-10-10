package com.fabiolopz.platzigram.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.fabiolopz.platzigram.R
import com.fabiolopz.platzigram.view.fragment.HomeFragment
import com.fabiolopz.platzigram.view.fragment.ProfileFragment
import com.fabiolopz.platzigram.view.fragment.SearchFragment
import com.roughike.bottombar.BottomBar

class ContainerActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val bottomBar: BottomBar = findViewById(R.id.bottombar)
        bottomBar.setDefaultTab(R.id.home)

        bottomBar.setOnTabSelectListener {
            when (it){
                R.id.home ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container,  HomeFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null).commit()
                R.id.profile ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container,  ProfileFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null).commit()
                R.id.search ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container,  SearchFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null).commit()
            }
        }
    }
}
