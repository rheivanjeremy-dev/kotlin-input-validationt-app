package com.mobprog.contohvalidasi

// 1. Import library yang diperlukan
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast // TAMBAHKAN INI
import androidx.appcompat.app.AppCompatActivity

// Pastikan nama class sama dengan nama file .kt Anda
class ActivityMain : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi View
        val etAngka1 = findViewById<EditText>(R.id.etAngka1)
        val etAngka2 = findViewById<EditText>(R.id.etAngka2)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnProses.setOnClickListener {

            // Validasi input kosong
            if (etAngka1.text.toString().isEmpty() || etAngka2.text.toString().isEmpty()) {
                tvHasil.text = "Input tidak boleh kosong"

                // PERBAIKAN: Penulisan Toast yang benar
                Toast.makeText(this, "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()

            } else {
                // Mengambil nilai dan version ke Int
                val angka1 = etAngka1.text.toString().toInt()
                val angka2 = etAngka2.text.toString().toInt()

                // PROSES ARITMATIKA
                val hasilTambah = angka1 + angka2
                val hasilKurang = angka1 - angka2
                val hasilKali = angka1 * angka2

                // Pembagian (Cek agar tidak bagi nol)
                val hasilBagi = if (angka2 != 0) {
                    (angka1.toDouble() / angka2.toDouble()).toString()
                } else {
                    "Tidak terhingga"
                }

                // MENAMPILKAN HASIL
                tvHasil.text = "Penjumlahan: $hasilTambah\n" +
                        "Pengurangan: $hasilKurang\n" +
                        "Perkalian: $hasilKali\n" +
                        "Pembagian: $hasilBagi"
            }
        }
    }
}