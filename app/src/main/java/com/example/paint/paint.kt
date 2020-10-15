//package com.example.paint
//
//import android.content.Context
//import android.graphics.*
//import android.os.Build
//import android.util.Log
//import android.view.*
//import androidx.annotation.RequiresApi
//
//
//
//class paint (CustomSurfaceView: SurfaceView, surfaceHolder: SurfaceHolder){
//    private var surfaceHolder: SurfaceHolder? = null
//    private var paint: Paint? = null
//    private var path: Path? = null
//    var color: Int? = null
//    var prevBitmap: Bitmap? = null
//    private var prevCanvas: Canvas? = null
//    private var canvas: Canvas? = null
//
//    var width: Int? = null
//    var height: Int? = null
//
//
//    constructor(context: Context, surfaceView: SurfaceView){
//        surfaceHolder = surfaceView.holder
//
//        /// display の情報（高さ 横）を取得
//        val size = Point().also {
//            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.apply {
//                getSize(
//                    it
//                )
//            }
//        }
//
//        /// surfaceViewのサイズ
//        width = size.x
//        height = size.y
//
//        /// 背景を透過させ、一番上に表示
//        surfaceHolder!!.setFormat(PixelFormat.TRANSPARENT)
//        surfaceView.setZOrderOnTop(true)
//
//        /// コールバック
////        surfaceHolder!!.addCallback(this)
//
//        /// ペイント関連の設定
//        paint = Paint()
//        color = Color.BLACK
//        paint!!.color = color as Int
//        paint!!.style = Paint.Style.STROKE
//        paint!!.strokeCap = Paint.Cap.ROUND
//        paint!!.isAntiAlias = true
//        paint!!.strokeWidth = 15F
//    }
//
//
//
//    private fun draw(pathInfo: pathInfo) {
////        canvas = Canvas()
//        /// ロックしてキャンバスを取得
//        val canvas = surfaceHolder!!.lockCanvas()
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
//
//
//    /// bitmapとcanvasの初期化
//    private fun initializeBitmap() {
//        if (prevBitmap == null) {
//            prevBitmap = Bitmap.createBitmap(width!!, height!!, Bitmap.Config.ARGB_8888)
//        }
//
//        if (prevCanvas == null) {
//            prevCanvas = Canvas(prevBitmap!!)
//        }
//
//        prevCanvas!!.drawColor(0, PorterDuff.Mode.CLEAR)
//    }
//
//
//
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun onTouch(event: MotionEvent): Boolean {
//        if (prevBitmap == null){
//            initializeBitmap()
//        }
//
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> Log.d("paint", "down ${event.x}, ${event.y}")
//            MotionEvent.ACTION_MOVE -> hoge(event.x, event.y)
//            MotionEvent.ACTION_UP -> Log.d("paint", "up ${event.x}, ${event.y}")
//        }
//
//        return true
//    }
//
////     path クラスで描画するポイントを保持
////        ACTION_DOWN 時の処理
////    private fun touchDown(x: Float, y: Float) {
////        path = Path()
////        path!!.moveTo(x, y)
////    }
////
////    ///    ACTION_MOVE 時の処理
////    private fun touchMove(x: Float, y: Float) {
////        /// pathクラスとdrawメソッドで線を書く
////        path!!.lineTo(x, y)
////        draw(pathInfo(path!!, color!!))
////        prevCanvas!!.drawPath(path!!, paint!!)
////
////    }
////
////    ///    ACTION_UP 時の処理
////    private fun touchUp(x: Float, y: Float) {
////        /// pathクラスとdrawメソッドで線を書く
////        path!!.lineTo(x, y)
////        draw(pathInfo(path, color?)()
////        /// 前回のキャンバスを描画
////        prevCanvas!!.drawPath(path!!, paint!!)
////    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun hoge(x: Float, y:Float){
//        var canvas = surfaceHolder?.lockCanvas()
//        //// キャンバスのクリア
//        canvas?.drawColor(Color.BLACK)
//        //長方形が描けるはず
//        var paint = Paint()
//        var lineStrokeWidth = 20F
//        paint.color = Color.argb(255f, 255f, 0f, 255f)
//
//        paint.style = Paint.Style.STROKE
//        canvas?.drawRect(300f, 300f, 600f, 600f, paint)
//        surfaceHolder?.unlockCanvasAndPost(canvas)
//    }
//}
//
//
//
////// pathクラスの情報とそのpathの色情報を保存する
//data class pathInfo(var path: Path, var color: Int) {
//}