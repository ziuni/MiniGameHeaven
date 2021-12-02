package com.example.minigameheaven

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.pow

class AirHockeyGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.air_hockey_game)

    }
}

class AirHockyPlayer(pusherX:Int, pusherY: Int, image:Bitmap){
    var pusherX = 0
    var pusherY = 0
    var image:Bitmap = image
    val pusherRect = Rect(pusherX, pusherY, pusherX+image.width*2, pusherY+image.height*2)
    init{
        this.pusherX = pusherX
        this.pusherY = pusherY
    }

    fun update(){
    }

    fun render(){

    }

    fun touchChck(x:Float, y:Float) : Boolean {
        //원 안에 터치한 x, y 좌표가 들어있다면 true, 아니면 false
        if(pow(((this.pusherY+image.height)-y).toDouble(), 2.0) + pow(((this.pusherX+image.width)-x).toDouble(), 2.0)
            < pow((image.width).toDouble(),2.0) ){
            return true
        }
        return false
    }
}

//그리기
class CustomView @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {
    //이미지 로드

    val basicM = 1000
    val clickM = 1001

    var imageTest = BitmapFactory.decodeResource(context.resources, R.drawable.air_hockey_table)

    val player1 = AirHockyPlayer(400, 100, BitmapFactory.decodeResource(context.resources, R.drawable.air_hockey_pushers))
    val player2 = AirHockyPlayer(400, 700, BitmapFactory.decodeResource(context.resources, R.drawable.air_hockey_pushers))

    var mode = basicM

    // 뷰의 내용이 렌더링 될때 호출 됩니다
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 여기다가 원하는걸 그리면 됩니다 :)
        if(canvas!=null) {
            val tableRect = Rect(0, 0, canvas.width, canvas.height)

            //캔버스에
            canvas?.drawColor(Color.WHITE);
            canvas?.drawBitmap(imageTest, null, tableRect, null)
            canvas?.drawBitmap(player1.image, null, player1.pusherRect, null)
            canvas?.drawBitmap(player2.image, null, player2.pusherRect, null)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event!!.x
        val y = event.y
        if(player1.touchChck(x, y)){
            mode = clickM
        }else{
            mode = basicM
        }
        if(mode==clickM) {
            Toast.makeText(this.context, "", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun setOnLongClickListener(l: OnLongClickListener?) {
        super.setOnLongClickListener(l)
    }

}