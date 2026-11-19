package com.aldi.utspbp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val ringkasan = findViewById<TextView>(R.id.tvRingkasan)
        val totalView = findViewById<TextView>(R.id.tvTotal)

        // Mengambil data dari Intent
        val satu = intent.getStringExtra("NAMA")
        // Mengambil teks dari EditText
        val dua = intent.getStringExtra("NAMA_EVENT")
        // Mengambil teks dari EditText
        val jumlah = intent.getIntExtra("JUMLAH_TIKET", 0)
        // Mengambil teks dari EditText
        val total = intent.getIntExtra("TOTAL", 0)
        // Menampilkan ringkasan dan total harga di TextView
        ringkasan.text = getString(R.string.telah_memesan_tiket_untuk, satu, jumlah, dua)
        totalView.text = total.toString()
    }
}
