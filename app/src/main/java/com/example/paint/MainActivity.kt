package com.example.paint

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val hoge = paint2(surfaceView)
//        black_btn.setOnClickListener {
//            hoge.clear(surfaceView)
//        }

        /// CustomSurfaceViewのインスタンスを生成しonTouchリスナーをセット
//        val customSurfaceView = paint2(this, surfaceView)
//        surfaceView.setOnTouchListener { v, event ->
//            customSurfaceView.onTouch(event)
//        }

//        /// カラーチェンジボタンにリスナーをセット
//        /// CustomSurfaceViewのchangeColorメソッドを呼び出す
//        black_btn.setOnClickListener {
//            customSurfaceView.changeColor("black")
//        }
//        red_btn.setOnClickListener {
//            customSurfaceView.changeColor("red")
//        }
//        blue_btn.setOnClickListener {
//            customSurfaceView.changeColor("green")
//        }
//
    }


}