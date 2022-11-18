package com.vk.homework2.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.vk.homework2.objects.Picture

class PictureDiffItemCallback: DiffUtil.ItemCallback<Picture>() {
    override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean {
        return oldItem.imageId() == newItem.imageId()
    }
}