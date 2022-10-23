package com.siskom.networkcall1.data

import android.telecom.Call
import com.siskom.networkcall1.model.DogFacts
import retrofit2.http.GET

interface DogFactsApiClient {
    @GET("api/facts?number=20")
    fun getfacts(): Call<DogFacts>
}