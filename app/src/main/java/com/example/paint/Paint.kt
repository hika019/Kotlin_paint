package com.example.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View


class PaintView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
    View(context, attrs) {
    val paint: Paint
    private val path: Path
    var tmp: Int? = null
    var color_data = color()


    init {
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
        //色部分追加
        Log.d("color", "color_data: ${color_data.color}")
        when(color_data.color){
            "black" -> paint.setColor(Color.BLACK)
            "red" -> paint.setColor(Color.RED)
            "blue" -> tmp = Color.BLUE
        }

        canvas.drawPath(path, paint)
        Log.d("color", "drow")
    }

    @Override
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                path.lineTo(x, y)
                invalidate()
            }
        }
        return true
    }

    fun clear() {
        path.reset()
        invalidate()
    }

}

class hoge(){
    var paint: Paint? = null
    var tmp:Int? = null
    fun change_color(color: String){
        when (color){
            "black" -> tmp = Color.BLACK
            "red" -> tmp = Color.RED
            "blue" -> tmp = Color.BLUE
        }
        Log.d("color", "${tmp}")
        paint?.color = tmp as Int

    }
}
