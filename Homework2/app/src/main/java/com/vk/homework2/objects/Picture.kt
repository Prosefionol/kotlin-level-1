package com.vk.homework2.objects

import com.google.gson.annotations.SerializedName

class Picture {
    @SerializedName("_id") var id = ""

    fun imageId() = id
}