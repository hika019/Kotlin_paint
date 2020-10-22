//package com.example.paint
//
//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.graphics.Path
//import android.util.AttributeSet
//import android.util.Log
//import android.view.MotionEvent
//import android.view.View
//
//
//class PaintView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
//    View(context, attrs) {
//    val paint: Paint
//    private val path: Path
//    var tmp: String? = null
//
//
//
//
//    init {
////        colorData.color = "black"
//        path = Path()
//        paint = Paint()
////        paint.setColor(Color.BLACK)
//        paint.setStyle(Paint.Style.STROKE)
//        paint.setStrokeJoin(Paint.Join.ROUND)
//        paint.setStrokeCap(Paint.Cap.ROUND)
//        paint.setStrokeWidth(10F)
//
//        Log.d("color", "init:${paint.color}")
//    }
//
//
//
//
//    @Override
//    override fun onDraw(canvas: Canvas) {
//        //色のデータを渡す
////        var color_data = path_color_data(path, paint.color).color
////
////
////        if (color_data != null) {
////            paint.setColor(color_data)
////        }
//        canvas.drawPath(path, paint)
//
////        Log.d("color", "color_data_class: ")
////        Log.d("color", "paint color: ${paint.color}")
//    }
//
//    @Override
//    override fun onTouchEvent(event: MotionEvent): Boolean {
//
//        //引数path_color_dataを消せばエラーは消える
//
//        val x = event.x
//        val y = event.y
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> touchDown(event.x, event.y)
//            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
//            MotionEvent.ACTION_UP -> touchUp(event.x, event.y)
//        }
//        return true
//    }
//
//
//    //touch関数
//    fun touchDown(x: Float, y: Float){
//        path.moveTo(x, y)
//        path_color_data(path!!, paint.color!!)
//        Log.d("color", "touchdoun color: ${paint.color}")
//        invalidate()
//    }
//    fun touchMove(x: Float, y: Float){
//        path.lineTo(x, y)
//        invalidate()
//    }
//    fun touchUp(x: Float, y: Float){
//        path.lineTo(x, y)
//        invalidate()
//    }
//
//    fun red(){
//        paint.setColor(Color.RED)
//        Log.d("color", "in red function: ${paint.color}")
//    }
//
//
//
//
//
//    fun clear() {
//        val canvas = Canvas()
//        canvas.drawColor(Color.RED)//こいつ画面全体をredで塗るはずがなんか動かん
//        invalidate()
//        Log.d("color", "in clear function")
//    }
//
//}
//
//
////// pathクラスの情報とそのpathの色情報を保存する
//data class path_color_data(
//    var path: Path?,
//    var color: Int?
//)