package com.vk.homework2.ui.main

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vk.homework2.R
import com.vk.homework2.objects.Picture

class PictureViewHolder(view: View): RecyclerView.ViewHolder(view) {
    protected val image by lazy { view.findViewById<ImageView>(R.id.image) }
    protected val imageLoader by lazy { Picasso.get() }

    fun bind(picture: Picture) {
        val url = "https://cataas.com/cat/${picture.imageId()}"
        imageLoader.load(url).into(image)
    }
}