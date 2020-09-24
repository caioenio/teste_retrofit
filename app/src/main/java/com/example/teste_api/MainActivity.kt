package com.example.teste_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //clique no evento e redireciona a view para a próxima tela
        btnSignup.setOnClickListener{
            val intent = Intent(this, activity_cadastro::class.java)
            startActivity(intent)
        }
    }
}