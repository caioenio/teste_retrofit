package com.example.teste_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit.client.ClientWeb
import retrofit.model.Client

class MainActivity : AppCompatActivity() {

    private val clients: MutableList<Client> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list()

        btnSignup.setOnClickListener{
            val intent = Intent(this, activity_cadastro::class.java)
            startActivity(intent)
        }
    }

    fun list(){
         val clients: MutableList<Client> = mutableListOf()
        ClientWeb().list({
            clients.addAll(it)
            Toast.makeText(this, "Trouxe", Toast.LENGTH_LONG).show()
        }, {
            Toast.makeText(this, "Falha ao buscar notas", Toast.LENGTH_LONG).show()
        })
    }
}