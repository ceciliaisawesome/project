package com.example.a_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import com.google.firebase.ktx.Firebase

class signupPage : AppCompatActivity() {
    lateinit var Btnsignup2: Button
    lateinit var Edtemail: EditText
    lateinit var Edtpass: EditText
    lateinit var Edtconfirmpass: EditText
    lateinit var Edtname: EditText
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
        Btnsignup2=findViewById(R.id.Btn_signup2)
        Edtemail=findViewById(R.id.Edt_email)
        Edtpass=findViewById(R.id.Edt_pass)
        Edtconfirmpass=findViewById(R.id.Edt_confirmpass)
        Edtname=findViewById(R.id.Edt_name)
        auth= Firebase.auth


        Btnsignup2.setOnClickListener {
            val intent= Intent (this, Loginpage::class.java)
            startActivity(intent)
        }
        Btnsignup2.setOnClickListener {
            Signupuser()
        }
    }
    private fun Signupuser(){
        val email=Edtemail.text.toString()
        val pass=Edtpass.text.toString()
        val confirmpass=Edtconfirmpass.text.toString()
        val name=Edtname.text.toString()

        if (email.isBlank()||pass.isBlank()||confirmpass.isBlank()||name.isBlank()){
            Toast.makeText(this, "Please password and email can't be blank", Toast.LENGTH_LONG)
            return
        }else if (pass!=confirmpass){
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Signed up successfully", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this, "Failed to create user", Toast.LENGTH_LONG).show()
            }
        }


    }
}