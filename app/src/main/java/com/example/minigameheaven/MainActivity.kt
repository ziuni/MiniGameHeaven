package com.example.minigameheaven

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //선언
        var i = 0
        var bell_button = findViewById<ImageButton>(R.id.bell_button_1)
        var grape_change_button = findViewById<ImageView>(R.id.image_grape)
        //선언END

        
        //버튼을 누른다면 이미지를 변경
        bell_button.setOnClickListener {
            Toast.makeText(this, "눌림", Toast.LENGTH_SHORT).show()
            i  = 1-i
            if(i==0){
                grape_change_button.setImageResource(R.drawable.grape)
            }else{
                grape_change_button.setImageResource(R.drawable.green_grape)
            }
        }

        var second : Int = 0
        timer(period = 1000, initialDelay = 1000){
            second++
            runOnUiThread {
                Toast.makeText(this@MainActivity, "" + second, Toast.LENGTH_SHORT).show()
            }

        }
    }
}