package com.vk.homework2.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.vk.homework2.objects.Picture

class PictureDiffItemCallback: DiffUtil.ItemCallback<PictureUIModel>() {
    override fun areItemsTheSame(oldItem: PictureUIModel, newItem: PictureUIModel): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: PictureUIModel, newItem: PictureUIModel): Boolean {
        return oldItem == newItem
    }
}