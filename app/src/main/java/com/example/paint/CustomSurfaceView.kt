package com.example.paint_surfaceview

import android.content.Context
import android.graphics.*
import android.os.Environment
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.lang.Exception


class CustomSurfaceView: SurfaceView, SurfaceHolder.Callback{

    private var surfaceHolder: SurfaceHolder? = null
    private var paint: Paint? = null
    private var path: Path? = null
    var color: Int? = null
    var prevBitmap: Bitmap? = null
    private var prevCanvas: Canvas? = null
    private var canvas: Canvas? = null

    var width: Int? = null
    var height: Int? = null

    constructor(context: Context, surfaceView: SurfaceView) : super(context) {
        surfaceHolder = surfaceView.holder

        /// display の情報（高さ 横）を取得
        val size = Point().also {
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.apply {
                getSize(
                    it
                )
            }
        }

        /// surfaceViewのサイズ
        width = size.x
        height = size.y

        /// 背景を透過させ、一番上に表示
        surfaceHolder!!.setFormat(PixelFormat.TRANSPARENT)
        surfaceView.setZOrderOnTop(true)

        /// コールバック
        surfaceHolder!!.addCallback(this)

        /// ペイント関連の設定
        paint = Paint()
        color = Color.BLACK
        paint!!.color = color as Int
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeCap = Paint.Cap.ROUND
        paint!!.isAntiAlias = true
        paint!!.strokeWidth = 15F //太さ
    }


    override fun surfaceCreated(holder: SurfaceHolder) {
        initializeBitmap()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        prevBitmap!!.recycle()
    }


    /// bitmapとcanvasの初期化
    private fun initializeBitmap() {
        if (prevBitmap == null) {
            prevBitmap = Bitmap.createBitmap(width!!, height!!, Bitmap.Config.ARGB_8888)
        }

        if (prevCanvas == null) {
            prevCanvas = Canvas(prevBitmap!!)
        }
        //背景白に
        prevCanvas!!.drawColor(Color.WHITE)
    }


    private fun draw(pathInfo: pathInfo) {
//        change_thickness()
        canvas = Canvas()
        /// ロックしてキャンバスを取得
        canvas = surfaceHolder!!.lockCanvas()

        //// キャンバスのクリア
        canvas!!.drawColor(0, PorterDuff.Mode.CLEAR)

        /// 前回のビットマップをキャンバスに描画
        canvas!!.drawBitmap(prevBitmap!!, 0F, 0F, null)

        //// pathを描画
        paint!!.color = pathInfo.color!!
        canvas!!.drawPath(pathInfo.path!!, paint!!)


        /// ロックを解除
        surfaceHolder!!.unlockCanvasAndPost(canvas)
    }


    /// 画面をタッチしたとき
    fun onTouch(event: MotionEvent) : Boolean{
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchDown(event.x, event.y)
            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
            MotionEvent.ACTION_UP -> touchUp(event.x, event.y)
        }
        return true
    }


    /// touchイベント(詳細)
    ///    ACTION_DOWN 時の処理
    private fun touchDown(x: Float, y: Float) {
        path = Path()
        path!!.moveTo(x, y)
    }

    ///    ACTION_MOVE 時の処理
    private fun touchMove(x: Float, y: Float) {
        /// pathクラスとdrawメソッドで線を書く
        path!!.lineTo(x, y)
        draw(pathInfo(path!!, color!!))
    }

    ///    ACTION_UP 時の処理
    private fun touchUp(x: Float, y: Float) {
        /// pathクラスとdrawメソッドで線を書く
        path!!.lineTo(x, y)
        draw(pathInfo(path!!, color!!))
        /// 前回のキャンバスを描画
        prevCanvas!!.drawPath(path!!, paint!!)
    }



    /// リセット
    fun reset() {
        ///初期化とキャンバスクリア
        initializeBitmap()
        canvas = surfaceHolder!!.lockCanvas()
        canvas?.drawColor(0, PorterDuff.Mode.CLEAR)
        surfaceHolder!!.unlockCanvasAndPost(canvas)
    }

    /// 色変更
    fun changeColor(colorSelected: String) {
        when (colorSelected) {
            "black" -> color = Color.BLACK
            "red" -> color = Color.RED
            "blue" -> color = Color.BLUE
            "white" -> color = Color.WHITE
        }
        paint!!.color = color as Int

//        if (editTextNumber2?.text.toString() != null){
//            Log.d("color", "tmp is : ${editTextNumber2?.text.toString()}")
//        }

    }


    //太さを変更
    fun change_thickness(width: Float?){
        if (width != null){
            //値が入った時
            paint!!.strokeWidth = width
            Log.d("color", "strokeWidth is set by float")
        }else{
            //デフォルト
            Log.d("color", "strokeWidth is default")

            if (paint!!.color == Color.WHITE){
                paint!!.strokeWidth = 45F
            }
            else{
                paint!!.strokeWidth = 15F
            }
        }
    }

    fun change_paint_width(size:String){
        when(size){
            "min" -> paint!!.strokeWidth = 15F
            "normal" -> paint!!.strokeWidth = 30F
            "big" -> paint!!.strokeWidth = 45F
        }
    }




    //未完成
    fun save(){
        var imgpath = Environment.getExternalStorageState()
        val file_name = "tmp.jpg"
        imgpath += file_name

        try {

            //保存処理
            if (prevBitmap == null ){
                Log.d("color", "bitmap is null")
            }else{
                Log.d("color", "bitmap is not null")
            }

            FileOutputStream(imgpath).use { outputStream ->
                prevBitmap?.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            }

            Toast.makeText(context, "image saved.", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(context, "${e}", Toast.LENGTH_LONG).show()
            Log.d("color", "${e}")
        }

    }

    fun save_tmp(){
        Toast.makeText(context, "未完成のため実行不可", Toast.LENGTH_SHORT).show()
    }

}

data class pathInfo(
    var path: Path?,
    var color: Int?
)