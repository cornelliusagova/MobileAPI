package com.example.responsimwszz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.responsimws.PostResponse
import com.example.responsimws.R

class PostAdapter (private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Tvbaca:TextView
        init {
            Tvbaca = itemView.findViewById(R.id.Tvbaca)
        }
        fun bind(postResponse: PostResponse){
            with(itemView){
                val data:String = "id_mahasiswa: ${postResponse.id_mahasiswa}\n" +
                        "nim: ${postResponse.nim}\n" +
                        "nama: ${postResponse.nama}\n"+
                        "nama_prodi: ${postResponse.nama_prodi}"
                Tvbaca.text = data


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int =list.size
}