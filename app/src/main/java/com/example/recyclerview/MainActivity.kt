package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<News>()


        for (i in 1..7) {
            val imageResId = when (i) {
                1 -> R.drawable.sealook2
                2 -> R.drawable.riize1
                3 -> R.drawable.riize2
                4 -> R.drawable.riize3
                5 -> R.drawable.riize5
                6 -> R.drawable.riize4
                7 -> R.drawable.riize6

                else -> R.drawable.default_image
            }
            val title = when (i) {
                1 -> "RIIZE Participate in SEALOOK's OST"
                2 -> "RIIZE to drop new single 'Talk Saxy' on Friday"
                3 -> "[2023 TMA] Rise ‘Next Leader’ Award… “Thank you Briize”"
                4 -> "[19 years since founding] ‘SM rookie’ Rise conquers the music industry in two months… Best Rookie No. 1"
                5 -> "‘SM Rookie’ Rise, Premiere Successfully Completed… Debut with fans"
                6 -> "RIIZE, a double success on music charts... Highest ranking among groups that debuted this year"
                7 -> "RIIZE takes off the veil with single ‘Talk Sexy’… Expecting performance and killing part"

                else -> "Item Default"
            }
            data.add(News(imageResId, title))

            val adapter = CustomAdapter(data)

            recyclerview.adapter = adapter

            adapter.setOnItemClickListener { news ->
                val position = data.indexOf(news)

                when (position) {
                    0 -> {
                        // Arahkan ke Activity pertama
                        val intent = Intent(this, Detail1::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        // Arahkan ke Activity kedua
                        val intent = Intent(this, Detail2::class.java)
                        startActivity(intent)
                    }
                    // Tambahkan logika untuk item lainnya
                    else -> {
                        // Arahkan ke Activity default atau tindakan lain
                        val intent = Intent(this, DefaultActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}