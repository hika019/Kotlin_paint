package com.example.paint

//https://qiita.com/InoueDaiki/items/3b51aaabdaad1c2227a3
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paint_class = PaintView(this)

        var colorData = color_data(null)





        black_btn.setOnClickListener {
            Log.d("color", "onClick black_btn")
            colorData.color = "black"
            Log.d("color", "main color_data: ${colorData.color}")
        }
        red_btn.setOnClickListener {
            Log.d("color", "onClick red_btn")
            colorData.color = "red"
            Log.d("color", "main color_data: ${colorData.color}")
        }
    }

}