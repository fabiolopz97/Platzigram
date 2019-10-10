package com.fabiolopz.platzigram.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.fabiolopz.platzigram.R
import com.fabiolopz.platzigram.adapter.PictureAdapterRecyclerView
import com.fabiolopz.platzigram.model.Picture

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_search, container, false)
        showToolbar("", false, view)
        val picturesRecycler: RecyclerView = view.findViewById(R.id.pictureSearchRecycler)

        val gridLayoutManager = GridLayoutManager(context, 2)
        //LinearLayoutManager(context)
        gridLayoutManager.orientation = GridLayoutManager.VERTICAL
        picturesRecycler.layoutManager = gridLayoutManager
        val pictureAdapterRecyclerView =
            PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, activity as AppCompatActivity)
        picturesRecycler.adapter = pictureAdapterRecyclerView
        return view
    }

    private fun buildPictures() = arrayListOf(
        Picture("https://concepto.de/wp-content/uploads/2015/03/paisaje-e1549600034372.jpg","Fabio Lopez", "4 días", "3 Me Gusta"),
        Picture("https://www.eltiempo.com/files/article_multimedia/uploads/2018/06/06/5b177c3b22c8e.jpeg","Maria Lopez", "3 días", "10 Me Gusta"),
        Picture("https://concepto.de/wp-content/uploads/2015/03/paisaje-2-e1549600987975.jpg","Sildres Lopez", "1 días", "5 Me Gusta"),
        Picture("https://locuraviajes.com/wp-content/uploads/2008/09/tn_paisaje-4.jpg","Vale Lopez", "1 días", "6 Me Gusta")
    )

    private fun showToolbar(title:String, upButton:Boolean, view:View){
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = title
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }
}