package com.siskom.networkcall1.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.siskom.networkcall1.R
import com.siskom.networkcall1.data.DogFactsApiClient
import com.siskom.networkcall1.databinding.ActivityMainBinding
import com.siskom.networkcall1.model.DogFacts
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TestingAdapter
    private val api by inject<DogFactsApiClient>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
        adapter = TestingAdapter()
        binding.rvContent.adapter = adapter
        binding.buttonChange.setOnClickListener { 
           api.getfacts().enqueue(object: retrofit2.Callback<DogFacts> {
               override fun onResponse(call: Call<DogFacts>, response: Response<DogFacts>) {
                   adapter.setNewInstance(response.body()?.facts?.filterNotNull()?.toMutableList())
               }

               override fun onFailure(call: Call<DogFacts>, t: Throwable) {
                   //belum ada
               }

           })
        }

    }
}