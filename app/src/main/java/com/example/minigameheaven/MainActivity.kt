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
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    /*
    할리갈리 규칙
    1. 시작하기 전에, 카드를 같은 개수로 나눠서 각자의 앞에 놓고, 종을 중앙에 놓는다.  -- 카드 나누기 해야함
    2. 정해진 방향으로 돌아가면서, 자기 차례가 되면 카드 한 장을 뒤집어서 앞에 놓는다.
    (만약 다른 카드가 펼쳐져 있으면 그 위에 놓는다. 카드를 뒤집을 때는 상대방이 먼저 볼 수 있도록 바깥쪽으로 뒤집는다.)
    3. 맨 위의 펼쳐진 모든 카드 중에서, 같은 종류의 과일이 정확하게 5개가 되어 있는 경우, 종을 친다.
    4. 가장 빨리 종을 친 사람이 펼쳐진 모든 카드를 가져간다. //종친사람은 화면에 보이는 카드를 모두 가져감
    5. 과일이 5개가 되어 있지 않은 경우 종을 치면, 벌칙으로 카드 한 장을 종 밑에 깔거나 상대방에게 카드 1장을 준다.//자신을 제외한 모두에게 카드 1장씩 나눠줌
    6. 카드를 모두 가져간 사람이 승자가 된다.
    * 카드 수 정해놓고 4명씩 14장 총 56장(14*4)_1개 5장, 2개 3장, 3개 3장, 4개 2장, 5개 1장
    //으악! 늦었다~ 닿을 수 없는 존재다...
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //선언
        //상수
        val YELLOW_SMILE = 301
        val PINK_SMILE = 302

        var cardReverse:Int = 0
        var bellButton = arrayOf(
                findViewById<ImageButton>(R.id.bell_button_1),
                findViewById<ImageButton>(R.id.bell_button_2),
                findViewById<ImageButton>(R.id.bell_button_3),
                findViewById<ImageButton>(R.id.bell_button_4),
        )

        //카드 위치
        //cardLoc1 cardLoc2
        //cardLoc3 cardLoc4
        var cardLoc1 = findViewById<ImageView>(R.id.card_loc_1)
        var cardLoc2 = findViewById<ImageView>(R.id.card_loc_2)
        var cardLoc3 = findViewById<ImageView>(R.id.card_loc_3)
        var cardLoc4 = findViewById<ImageView>(R.id.card_loc_4)

        var YcardImgResArr:Array<Int> = arrayOf(R.drawable.card_1, R.drawable.card_2,
                R.drawable.card_3, R.drawable.card_4, R.drawable.card_5keycard)
        var PcardImgResArr:Array<Int> = arrayOf(R.drawable.card_1_pink, R.drawable.card_2_pink,
                R.drawable.card_3_pink, R.drawable.card_4_pink, R.drawable.card_5keycard_pink)

        //임시
        //카드가 어떤 종류인지?를 정수형으로  순서대로 위치 1,2,3,4
        var cardLocItemArr:Array<Int> = arrayOf(YELLOW_SMILE, YELLOW_SMILE, YELLOW_SMILE, YELLOW_SMILE)
        //그 위치의 카드에 그림이 몇개가 있는지 저장 순서대로 위치 1,2,3,4
        var cardLocNumArr:Array<Int> = arrayOf(1, 2, 3, 4)

        //선언END

        //카드뽑기
        //자동으로 카드를 뽑고 뽑은 아이템의 종류와 갯수를 cardLocItem과 cardLocNum 배열에 저장해둔다.

        fun cardDraw(idx:Int, randomItem:Int, randomCard:Int, cardLoc:ImageView){
            cardLocItemArr[idx] = 300+randomItem //4번 위치의 카드의 종류를 저장해놓는다.
            cardLocNumArr[idx] = randomCard+1
            if(cardLocItemArr[idx] == PINK_SMILE){
                cardLoc.setImageResource(PcardImgResArr[randomCard]) //4번 위치의 카드를 낸다.
            }else if(cardLocItemArr[idx] == YELLOW_SMILE) {
                cardLoc.setImageResource(YcardImgResArr[randomCard]) //4번 위치의 카드를 낸다.
            }
        }

        //1초마다 카드 뒤집기(1 -> 2 -> 3 -> 4순으로)
        //랜덤으로 1 ~ 5번 카드로 바꾸기
        timer(period = 1000){
            cardReverse++ //1초마다 카드 뒤집기(1번 위치의 카드부터)
            var cardLocNum = cardReverse%4 //1은 1, 2는 2, 3은 3, 4번째 카드는 0번(카드의 위치를 1, 2, 3, 0으로 업뎃..)
            var randomCard = Random().nextInt(5) // 0 ~ 4의 카드 랜덤 뽑아놓기
            var randomItem = Random().nextInt(2)+1 //카드 아이템 랜덤으로 뽑기

            runOnUiThread {
                when(cardLocNum)
                {
                    //4번째 위치의 카드
                    0 -> { cardDraw(3, randomItem, randomCard, cardLoc4) }
                    //1번째 위치의 카드
                    1 -> { cardDraw(0, randomItem, randomCard, cardLoc1) }
                    //2번째 위치의 카드
                    2 -> { cardDraw(1, randomItem, randomCard, cardLoc2) }
                    //3번째 위치의 카드
                    3 -> { cardDraw(2, randomItem, randomCard, cardLoc3) }
                    else ->   { Toast.makeText(this@MainActivity, "오류!", Toast.LENGTH_SHORT).show() }
                }
            }

        }

        //카드뽑기 END

        //벨 누르기
        fun bellDown(){
            var YcardSum = 0
            var PcardSum = 0
            for(i in cardLocNumArr.indices){
                when(cardLocItemArr[i]){
                    YELLOW_SMILE->{ YcardSum+=cardLocNumArr[i] }
                    PINK_SMILE->{ PcardSum+=cardLocNumArr[i] }
                }
            }
            if(YcardSum == 5 || PcardSum == 5 ) {
                Toast.makeText(this@MainActivity, "5개!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "5개 NO!", Toast.LENGTH_SHORT).show()
            }
        }

        //임시
        bellButton[0].setOnClickListener {
            bellDown()
        }
        bellButton[1].setOnClickListener {
            bellDown()
        }
        bellButton[2].setOnClickListener {
            bellDown()
        }
        bellButton[3].setOnClickListener {
            bellDown()
        }
        //벨 누르기 END
    }
}

//private operator fun Int.set(i: Int, value: Int) {
//
//}