package com.example.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.example.paint.*


class PaintView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
    View(context, attrs) {
    val paint: Paint
    private val path: Path
    var tmp: String? = null




    init {
//        colorData.color = "black"
        path = Path()
        paint = Paint()
//        paint.setColor(Color.BLACK)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeJoin(Paint.Join.ROUND)
        paint.setStrokeCap(Paint.Cap.ROUND)
        paint.setStrokeWidth(10F)

        Log.d("color", "init:${paint.color}")
    }




    @Override
    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)

        Log.d("color", "color_data_class: ")
        Log.d("color", "paint color: ${paint.color}")
    }

    @Override
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchDown(event.x, event.y)
            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
            MotionEvent.ACTION_UP -> touchUp(event.x, event.y)
        }
        return true
    }


    //touch関数
    fun touchDown(x:Float, y:Float){
        path.moveTo(x, y)
        invalidate()
    }
    fun touchMove(x:Float, y:Float){
        path.lineTo(x, y)
        invalidate()
    }
    fun touchUp(x: Float, y: Float){
        path.lineTo(x, y)
        invalidate()
    }




    fun clear() {
        path.reset()
        invalidate()
    }

}



data class path_data(
    var path: Path,
    var color: Int
)
