package com.vk.homework2.businesslayer

import com.vk.homework2.datalayer.IAccessor
import com.vk.homework2.objects.Picture

class PictureProvider(val accessor: IAccessor) {
    suspend fun getPictures(offset: Int, limit: Int): List<Picture> {
        return accessor.getPictures(offset, limit)
    }
}