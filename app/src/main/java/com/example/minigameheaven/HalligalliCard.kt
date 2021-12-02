package com.example.minigameheaven

import java.util.*

class HalligalliCard {
    var Cards = emptyArray<Int?>()
    var PlayerCard = emptyArray<Int?>()

    init {
        Cards = arrayOfNulls(56)
        for (i in 0..4)  // 1개짜리 카드 이미지설정
        {
            Cards[14 * 0 + i] = R.drawable.halligalli_cat_card_1
            Cards[14 * 1 + i] = R.drawable.halligalli_dog_card_1
            Cards[14 * 2 + i] = R.drawable.halligalli_meerkat_card_1
            Cards[14 * 3 + i] = R.drawable.halligalli_penguin_card_1
        }
        for (i in 0..2)  // 2,3개짜리 카드 이미지설정
        {
            Cards[14 * 0 + i + 5] = R.drawable.halligalli_cat_card_2
            Cards[14 * 1 + i + 5] = R.drawable.halligalli_dog_card_2
            Cards[14 * 2 + i + 5] = R.drawable.halligalli_meerkat_card_2
            Cards[14 * 3 + i + 5] = R.drawable.halligalli_penguin_card_2

            Cards[14 * 0 + i + 8] = R.drawable.halligalli_cat_card_3
            Cards[14 * 1 + i + 8] = R.drawable.halligalli_dog_card_3
            Cards[14 * 2 + i + 8] = R.drawable.halligalli_meerkat_card_3
            Cards[14 * 3 + i + 8] = R.drawable.halligalli_penguin_card_3
        }
        for (i in 0..1)  // 4개짜리 카드 이미지설정
        {
            Cards[14 * 0 + i + 11] = R.drawable.halligalli_cat_card_4
            Cards[14 * 1 + i + 11] = R.drawable.halligalli_dog_card_4
            Cards[14 * 2 + i + 11] = R.drawable.halligalli_meerkat_card_4
            Cards[14 * 3 + i + 11] = R.drawable.halligalli_penguin_card_4
        }
        // 5개짜리 카드 이미지설정
        Cards[14 * 0 + 13] = R.drawable.halligalli_cat_card_5
        Cards[14 * 1 + 13] = R.drawable.halligalli_dog_card_5
        Cards[14 * 2 + 13] = R.drawable.halligalli_meerkat_card_5
        Cards[14 * 3 + 13] = R.drawable.halligalli_penguin_card_5
    }

    fun CardShuffle(): Array<Int?> {
        PlayerCard = arrayOfNulls(14)
        val ra = Random()
        var i = 0
        while (i < 14) {
            val tmp = ra.nextInt(56)
            if (Cards[tmp] == null) {
                continue
            }
            PlayerCard[i] = Cards[tmp]
            Cards[tmp] = null
            i++
        }
        return PlayerCard
    }
}


//
//import com.example.minigameheaven.Card
//import java.util.*
//
//class Card internal constructor() {
//    companion object {
//        const val ANIMAL = 4
//        const val CARDCNT = 14 //플레이어에게 나눠줄 카드 갯수
//        const val CARDNUM = 5 //카드 종류별 갯수
//    }
//
//    //3초 - speed 속도로 카드 뒤집기
//    //한사람이 모든 카드를 다 가지면 승리
//    //카드는 랜덤
//    //* 카드 수 정해놓고 4명씩 14장 총 56장(14*4)_1개 5장, 2개 3장, 3개 3장, 4개 2장, 5개 1장
//    //배열에다 동물별로 카드를 담음(14 * 4)
//    var Card = arrayOf(
//        intArrayOf(5, 3, 3, 2, 1), //냥
//        intArrayOf(5, 3, 3, 2, 1), //멍
//        intArrayOf(5, 3, 3, 2, 1), //미어캣
//        intArrayOf(5, 3, 3, 2, 1)  //펭귄
//    )
//
//    //0cat 1dog 2meerkat 3penguin
//    var PlayerCard1 = Array(ANIMAL) { IntArray(CARDCNT) } //동물, 나누는 카드 수
//    var PlayerCard2 = Array(ANIMAL) { IntArray(CARDCNT) }
//    var PlayerCard3 = Array(ANIMAL) { IntArray(CARDCNT) }
//    var PlayerCard4 = Array(ANIMAL) { IntArray(CARDCNT) }
//    var cnt = arrayOf(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0))
//    fun CardToPlayer() {
//        val rand = Random()
//        var i = 0
//        while (i < ANIMAL) {
//            PlayerCard1[i][0] = rand.nextInt(4) //동물 랜덤
//            var j = 0
//            while (i < 5) {
//                PlayerCard1[i][j] = rand.nextInt(5) //카드 종류 랜덤(1~5)
//                for (k in 0 until j) {
//                    if (PlayerCard1[i][j] == PlayerCard1[i][k]) {
//                        j--
//                        break
//                    } //end if
//                } //end for(k)
//                cnt[i][j]++
//                if (cnt[i][j] >= Card[i][j]) {
//                    i--
//                    break
//                } //end if
//                j++
//            }
//            i++
//        }
//    }
//
//    init { //한 사람당 14장 씩
//        println("카드 생성")
//    }
//}