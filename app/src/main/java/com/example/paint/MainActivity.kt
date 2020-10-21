package com.example.paint

//https://qiita.com/InoueDaiki/items/3b51aaabdaad1c2227a3
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paint_class = PaintView(this)



    }

    fun change_color(color_str:String, pathData: path_data){
        var color:Int = Color.BLACK
        when(color_str){
            "black" -> color = Color.BLACK
            "red" -> color = Color.RED
            "blue" -> color = Color.BLUE
        }
        pathData.color = color
    }
}