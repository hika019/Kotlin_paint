package com.example.paint

import android.graphics.*
import android.util.Log
import android.view.*

class paint (CustomSurfaceView: SurfaceView){
    private var surfaceHolder: SurfaceHolder? = null
    private var paint: Paint? = null
    private var path: Path? = null
    var color: Int? = null
    var prevBitmap: Bitmap? = null
    private var prevCanvas: Canvas? = null
    private var canvas: Canvas? = null

    var width: Int? = null
    var height: Int? = null


//    private fun draw(pathInfo: pathInfo) {
//        canvas = Canvas()
//
//        /// ロックしてキャンバスを取得
//        canvas = surfaceHolder!!.lockCanvas()
//
//        //// キャンバスのクリア
//        canvas!!.drawColor(0, PorterDuff.Mode.CLEAR)
//
//        /// 前回のビットマップをキャンバスに描画
//        canvas!!.drawBitmap(prevBitmap!!, 0F, 0F, null)
//
//        //// pathを描画
//        paint!!.color = pathInfo.color
//        canvas!!.drawPath(pathInfo.path, paint!!)
//
//        /// ロックを解除
//        surfaceHolder!!.unlockCanvasAndPost(canvas)
//    }

    fun onTouch(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> Log.d("point", "down: ${event.x}, ${event.y}")
            MotionEvent.ACTION_MOVE -> Log.d("point", "move: ${event.x}, ${event.y}")
            MotionEvent.ACTION_UP -> Log.d("point", "up: ${event.x}, ${event.y}")
        }

        return true
    }

//    // path クラスで描画するポイントを保持
//    //    ACTION_DOWN 時の処理
//    private fun touchDown(x: Float, y: Float) {
//        path = Path()
//        path!!.moveTo(x, y)
//    }
//
//    ///    ACTION_MOVE 時の処理
//    private fun touchMove(x: Float, y: Float) {
//        /// pathクラスとdrawメソッドで線を書く
//        path!!.lineTo(x, y)
//        draw(pathInfo(path!!, color!!))
//    }
//
//    ///    ACTION_UP 時の処理
//    private fun touchUp(x: Float, y: Float) {
//        /// pathクラスとdrawメソッドで線を書く
//        path!!.lineTo(x, y)
//        draw(pathInfo(path!!, color!!))
//        /// 前回のキャンバスを描画
//        prevCanvas!!.drawPath(path!!, paint!!)
//    }

}

//// pathクラスの情報とそのpathの色情報を保存する
data class pathInfo(var path: Path, var color: Int) {
}