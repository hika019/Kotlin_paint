package com.example.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class PaintView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
    View(context, attrs) {
    private val paint: Paint
    private val path: Path

    init {
        path = Path()
        paint = Paint()
//        paint.setColor(-0x1000000)
        paint.setColor(-0x0FF0F0F)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeJoin(Paint.Join.ROUND)
        paint.setStrokeCap(Paint.Cap.ROUND)
        paint.setStrokeWidth(10F)
    }

    @Override
    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
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

}