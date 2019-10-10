package com.fabiolopz.platzigram.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.transition.Explode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fabiolopz.platzigram.R
import com.fabiolopz.platzigram.model.Picture
import com.fabiolopz.platzigram.view.PictureDetailActivity
import com.squareup.picasso.Picasso

class PictureAdapterRecyclerView(
    private val pictures: ArrayList<Picture>,
    private val resource: Int,
    private val activity: Activity
):RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view:View = LayoutInflater
            .from(parent.context).inflate(resource, parent, false)
        return PictureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val picture:Picture = pictures[position]
        holder.usernameCard?.text = picture.userName
        holder.timeCardCard?.text = picture.time
        holder.likeNumberCard?.text = picture.like_number
        Picasso.get().load(picture.picture).into(holder.pictureCard)
        holder.pictureCard?.setOnClickListener {
            val intent = Intent(activity, PictureDetailActivity::class.java)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                val explode = Explode()
                explode.duration = 1000
                activity.window.exitTransition =  explode
                activity.startActivity(intent, ActivityOptions
                    .makeSceneTransitionAnimation(activity, it, activity.getString(R.string.transitionname_picture)).toBundle())
            } else {
                activity.startActivity(intent)
            }

        }
    }

    class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pictureCard: ImageView? = itemView.findViewById(R.id.pictureCard)
        var usernameCard: TextView? = itemView.findViewById(R.id.userNameCard)
        var timeCardCard: TextView? = itemView.findViewById(R.id.timeCard)
        var likeNumberCard: TextView? = itemView.findViewById(R.id.likeNumberCard)
    }

}