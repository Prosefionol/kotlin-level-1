package com.vk.homework2.businesslayer

import com.vk.homework2.datalayer.CatsPictureAccessor
import com.vk.homework2.objects.Picture

class PictureInteractor(private val pictureAccessor: CatsPictureAccessor) {
    suspend fun getPictures(offset: Int, limit: Int): List<Picture> {
        return pictureAccessor.getPictures(offset, limit)
    }
}