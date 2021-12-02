package com.example.minigameheaven

class HalligalliPlayer{
    private var cardNum = 14; //14장

    init{
        //초기화 및 유효성 검사 코드

    }

    fun update(){

    }

    fun render(){

    }

    fun getCardNum(): Int {
        return cardNum
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

        if(cardNum==HalligalliGlobal.CARD_NUM_MAX){

        }
    }

    fun failPushBell(curCardNum:Int){
        // 벨 잘못 눌렀으면
        //카드 하나를 뺏음
        cardNum--;
    }
}