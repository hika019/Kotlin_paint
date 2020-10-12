package com.example.paint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// CustomSurfaceViewのインスタンスを生成しonTouchリスナーをセット
        val customSurfaceView = paint(surfaceView)
        surfaceView.setOnTouchListener { v, event ->
            customSurfaceView.onTouch(event)
        }
    }
}