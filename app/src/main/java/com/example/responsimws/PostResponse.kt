package com.example.responsimws

data class PostResponse(
    val id_mahasiswa: Int,
    val nim: Int,
    val nama: String?,
    val nama_prodi: String?
)