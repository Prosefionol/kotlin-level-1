package com.vk.homework2.ui.main

import androidx.lifecycle.ViewModel
import com.vk.homework2.businesslayer.PictureProvider
import com.vk.homework2.datalayer.IAccessor

class MainViewModel : ViewModel() {
    private val accessor = IAccessor.create()
    private val provider = PictureProvider(accessor)

    suspend fun getPictures() = provider.getPictures(0,10)
}