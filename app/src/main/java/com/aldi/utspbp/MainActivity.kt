package com.aldi.utspbp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val satu = findViewById<EditText>(R.id.etSatu)
        val dua = findViewById<EditText>(R.id.etDua)
        val jumlahView = findViewById<EditText>(R.id.etJumlah)
        val tombol = findViewById<Button>(R.id.btnHitung)

        tombol.setOnClickListener {
            // 1. Ambil semua input sebagai String terlebih dahulu
            val teksSatu = satu.text.toString().trim()
            val teksDua = dua.text.toString().trim()
            val teksJumlah = jumlahView.text.toString().trim()

            // 2. Konversi ke Int secara aman (hasilnya null jika kosong/bukan angka)
            val jumlah = teksJumlah.toIntOrNull()

            // 3. Lakukan validasi berurutan
            if (teksSatu.isEmpty()) {
                satu.error = "Nama tidak boleh kosong"
                satu.requestFocus()
            } else if (teksDua.isEmpty()) {
                dua.error = "Nama event tidak boleh kosong"
                dua.requestFocus()
            } else if (teksJumlah.isEmpty()) {
                jumlahView.error = "Jumlah tiket tidak boleh kosong"
                jumlahView.requestFocus()
            } else if (jumlah == null || jumlah < 1 || jumlah > 10) {
                jumlahView.error = "Jumlah tiket harus berupa angka antara 1 dan 10"
                jumlahView.requestFocus()
            } else {
                // 4. Hitung total harga dan pindah Activity jika semua valid
                val tarif = 75000
                val total = jumlah * tarif

                // Intent explicit untuk pindah ResultActivity
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("NAMA", teksSatu)
                    putExtra("NAMA_EVENT", teksDua)
                    putExtra("JUMLAH_TIKET", jumlah)
                    putExtra("TOTAL", total)
                }
                startActivity(intent)
            }
        }
    }
}
