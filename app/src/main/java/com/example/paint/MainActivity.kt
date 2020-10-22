package com.example.paint

//https://qiita.com/InoueDaiki/items/3b51aaabdaad1c2227a3
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.paint_surfaceview.CustomSurfaceView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// CustomSurfaceViewのインスタンスを生成しonTouchリスナーをセット
        val customSurfaceView = CustomSurfaceView(this,surfaceView)
        surfaceView.setOnTouchListener { v, event ->
            customSurfaceView.onTouch(event)
        }

        black_btn.setOnClickListener {
            customSurfaceView.changeColor("black")
        }
        red_btn.setOnClickListener {
            customSurfaceView.changeColor("red")
        }
        blue_btn.setOnClickListener {
            customSurfaceView.changeColor("blue")
        }

        eraser_btn.setOnClickListener {
            customSurfaceView.changeColor("white")
        }


//        reset_btn.setOnClickListener {
//            customSurfaceView.reset()
//        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}