package com.example.moviles1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast



class LoginActicity : AppCompatActivity() {
    private var edtTxtPsswd: EditText? = null
    private var edtTxtUsrNm: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtTxtUsrNm = findViewById(R.id.edtTxtUsrNm)
        edtTxtPsswd = findViewById(R.id.edtTxtPsswd)
    }

    fun onLogin (view : View){
        if (edtTxtUsrNm!!.text.toString() =="LEPE"){
            if (edtTxtPsswd!!.text.toString()=="123") {
                val intento = Intent(this, barra_navegacion::class.java)
                startActivity(intento)
            }
        }
        else {
            Toast.makeText(this,"Incorrect User or Password",Toast.LENGTH_LONG).show()
        }
    }

    fun onRegister (view : View){
        val  intento = Intent(this, Register::class.java)
        startActivity(intento)
    }
    fun onRecuperar (view : View){
        val  intento = Intent(this, TaskActivity::class.java)
        startActivity(intento)
    }
}
