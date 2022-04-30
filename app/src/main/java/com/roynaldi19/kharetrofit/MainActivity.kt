package com.roynaldi19.kharetrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.roynaldi19.kharetrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<PostResponse>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPost.setHasFixedSize(true)
        binding.rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPost().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val responseCode = response.code().toString()
                binding.tvResponse.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                binding.rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
