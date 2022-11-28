package com.vk.homework2.ui.main

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vk.homework2.R

class PictureViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image by lazy { view.findViewById<ImageView>(R.id.image) }
    private val imageLoader by lazy { Picasso.get() }

    fun bind(picture: PictureUIModel) {
        imageLoader.load(picture.url).into(image)
    }
}