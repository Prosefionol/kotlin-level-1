package com.vk.homework2.ui.main

import androidx.lifecycle.ViewModel
import com.vk.homework2.businesslayer.PictureInteractor
import com.vk.homework2.datalayer.CatsPictureAccessor
import com.vk.homework2.objects.Picture

class MainViewModel : ViewModel() {
    private val accessor = CatsPictureAccessor.create()
    private val provider = PictureInteractor(accessor)

    suspend fun getPictures(): List<PictureUIModel> = provider.getPictures(0,10).map { convertToUIModel(it) }

    private fun convertToUIModel(picture: Picture): PictureUIModel {
        val url = "https://cataas.com/cat/${picture.id}"
        return PictureUIModel(url)
    }
}