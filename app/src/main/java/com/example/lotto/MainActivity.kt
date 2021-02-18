package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lotteryNumbers = arrayListOf(number1, number2, number3, number4, number5, number6)
        
        val countDownTimer = object : CountDownTimer(3000, 100){
            override fun onFinish() {

            }

            override fun onTick(millisUntilFinished: Long) {
                lotteryNumbers.forEach {
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }

        }
        
        lottie_btn.setOnClickListener {
            if (lottie_btn.isAnimating){
                lottie_btn.cancelAnimation()
                countDownTimer.cancel()
            }else{
                lottie_btn.playAnimation()
                countDownTimer.start()
            }
            lottie_btn.playAnimation()
            countDownTimer.start()
        }
    }
}