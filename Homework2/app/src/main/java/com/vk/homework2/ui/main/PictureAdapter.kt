package com.vk.homework2.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.vk.homework2.R
import com.vk.homework2.objects.Picture

class PictureAdapter: ListAdapter<PictureUIModel, PictureViewHolder>(PictureDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.picture_item, parent, false)
        return PictureViewHolder(view)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val picture = getItem(position)
        holder.bind(picture)
    }

}