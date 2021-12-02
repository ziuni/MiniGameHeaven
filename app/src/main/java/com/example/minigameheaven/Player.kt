package com.example.minigameheaven

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Player{
    private var cardNum = 14; //14장

    init{
        //초기화 및 유효성 검사 코드

    }

    fun cardPlay(){
        //카드 한장씩 main판에 내기
        // 자기 차례가 되면 카드 한 장을 뒤집어서 앞에 놓는다.
        cardNum--;
    }

    fun succesPushBell(curCardNum:Int){
        //5개일 때 벨 눌렀으면
        //놓여져있는 카드를 모두 가져옴
        cardNum+=curCardNum;

        if(cardNum==global.CARD_NUM_MAX){

        }
    }

    fun failPushBell(curCardNum:Int){
        // 벨 잘못 눌렀으면
        //카드 하나를 뺏음
        cardNum--;
    }
}