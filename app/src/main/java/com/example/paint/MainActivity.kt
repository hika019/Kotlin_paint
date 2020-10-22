package com.example.paint

//https://qiita.com/InoueDaiki/items/3b51aaabdaad1c2227a3
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paint_class = PaintView(this)

        black_btn.setOnClickListener {
            change_color("black")
        }
        red_btn.setOnClickListener {
            change_color("red")
            val tmp= PaintView(this, null)
            tmp.red()
//            Log.d("color", "Click red_btn :${}")
        }
        blue_btn.setOnClickListener {
            change_color("blue")
        }
        eraser.setOnClickListener {
            Log.d("color", "eraser on Click")
            val tmp= PaintView(this, null)
            tmp.clear()

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    fun change_color(color_str: String):String{
        val colorData = path_color_data(null, null)

        var color = Color.BLACK
        when(color_str){
            "black" -> color = Color.BLACK
            "red" -> color = Color.RED
            "blue" -> color = Color.BLUE
        }
        colorData.color = color
        Log.d("color_main", "${colorData.color}")
        return color_str
    }
}