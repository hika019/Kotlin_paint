package com.example.paint



import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.paint_surfaceview.CustomSurfaceView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout
    //キーボード制御用オブジェクト
    private lateinit var inputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paint_width_edittext.setOnFocusChangeListener{ v, hasFocus ->
            if (!hasFocus){
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
            }
        }

        /// CustomSurfaceViewのインスタンスを生成しonTouchリスナーをセット
        val customSurfaceView = CustomSurfaceView(this,surfaceView)
        surfaceView.setOnTouchListener { v, event ->
            customSurfaceView.onTouch(event)
        }

        //色のボタンが押されたらchangeColor()にstringを渡す
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
        clear_btn.setOnClickListener {
            customSurfaceView.reset()
        }
        save.setOnClickListener {
            customSurfaceView.save_tmp()
        }

        //確定ボタンが押される
        change_thickness_btn.setOnClickListener {
            val width = paint_width_edittext?.text
            //空か判定
            if (width!!.isEmpty()){
                Log.d("color", "width _str is null")
                customSurfaceView.change_thickness(null)
                Toast.makeText(applicationContext, "デフォルト値が設定されました", Toast.LENGTH_SHORT).show()
            }else{
                Log.d("color", "width _str is not null")
                customSurfaceView.change_thickness(width!!.toString()!!.toFloat())
                Toast.makeText(applicationContext, "太さ${width!!.toString().toFloat()}が設定されました", Toast.LENGTH_SHORT).show()

            }
        }


    }


    //キーボードを隠す
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        back.requestFocus()
        return super.dispatchTouchEvent(ev)
    }



    //メニュー表示
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //メニューアクション
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.save_btn -> {
                val customSurfaceView = CustomSurfaceView(this, surfaceView)
                customSurfaceView.save_tmp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}