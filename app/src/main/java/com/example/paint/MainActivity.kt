package com.example.paint

//https://qiita.com/InoueDaiki/items/3b51aaabdaad1c2227a3
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paint_class = PaintView(this)
//        val colorData = color_data()
//
//        black_btn.setOnClickListener {
//            change_color("black")
//        }
//        red_btn.setOnClickListener {
//            change_color("red")
//            Log.d("color", "Click red_btn :${colorData.color}")
//        }
//        black_btn.setOnClickListener {
//            change_color("blue")
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


//    fun change_color(color_str:String){
//        val colorData = color_data()
//
//        var color = Color.BLACK
//        when(color_str){
//            "black" -> color = Color.BLACK
//            "red" -> color = Color.RED
//            "blue" -> color = Color.BLUE
//        }
//        colorData.color = color
//    }
}