package com.example.sherlocked1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        dc.isVisible=false
        button3.setOnClickListener {
            if(ac.isVisible)
            {
                button3.text="Change to Digital Clock"
                ac.isVisible=false
                dc.isVisible=true
            }
            else
            {
                button3.text="Change to Analog Clock"
                ac.isVisible=true
                dc.isVisible=false
            }
        }
    }
}
