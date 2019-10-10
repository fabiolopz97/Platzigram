package com.fabiolopz.platzigram.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.fabiolopz.platzigram.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class PictureDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detail)
        showToolbar("", true)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.enterTransition = Fade()
        }
    }

    private fun showToolbar(title:String, upButton:Boolean){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
        val collapsingToolbarLayout:CollapsingToolbarLayout = findViewById(R.id.collapsingToolbar)
    }
}
