package com.vk.homework2.datalayer

import com.vk.homework2.objects.Picture
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IAccessor {
    @GET("/api/cats")
    @Headers("X-User-Agent: meow")
    suspend fun getPictures(@Query("skip") offset: Int, @Query("limit") limit: Int): List<Picture>

    companion object {
        fun create(): IAccessor {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder().apply {
                addNetworkInterceptor(loggingInterceptor)
            }.build()

            val retrofit = Retrofit.Builder().apply {
                client(client)
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://cataas.com/")
            }.build()

            return retrofit.create(IAccessor::class.java)
        }
    }
}