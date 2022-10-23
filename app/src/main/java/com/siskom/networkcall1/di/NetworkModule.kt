package com.siskom.networkcall1.di

import com.siskom.networkcall1.data.DogFactsApiClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface NetworkModule {
    fun initNetworkModule():Module {
        return module {
            single {
                Retrofit.Builder()
                    .baseUrl("https://dog-api.kinduff.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            single {
                get<Retrofit>().create(DogFactsApiClient::class.java)
            }
        }
    }
}