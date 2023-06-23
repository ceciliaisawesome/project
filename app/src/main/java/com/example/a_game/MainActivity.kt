package com.example.a_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var Btnsignup:Button
    lateinit var Txtlogin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btnsignup=findViewById(R.id.Btn_signup)
        Txtlogin=findViewById(R.id.Txt_login)

        Btnsignup.setOnClickListener {
            val intent=Intent(this, signupPage::class.java)
            startActivity(intent)
        }
        Txtlogin.setOnClickListener {
            val intent=Intent(this, Loginpage::class.java)
            startActivity(intent)
        }
    }
}