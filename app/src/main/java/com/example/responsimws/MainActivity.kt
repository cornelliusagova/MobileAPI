package com.example.responsimws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.responsimwszz.PostAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<PostResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvPengguna:RecyclerView = findViewById(R.id.rvPengguna)
        val tvResponse:TextView = findViewById(R.id.tvResponse)
        rvPengguna.setHasFixedSize(true)
        rvPengguna.layoutManager = LinearLayoutManager(this)

        RetrofitCilent.instance.getPosts().enqueue(object: Callback<ArrayList<PostResponse>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>,
            ) {
              val responseCode = response.code().toString()
                tvResponse.text = responseCode
                response.body()?.let { list.addAll(it)}
                val adapter = PostAdapter(list)
                rvPengguna.adapter = adapter

            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

            }
        })
    }
}