package com.example.teste_api

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit.client.ClientWeb
import retrofit.model.Client

class MainActivity : AppCompatActivity() {

    private val clients: MutableList<Client> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ClientWeb().list({
            clients.addAll(it)
            configureList()
            Toast.makeText(this, "Trouxe", Toast.LENGTH_LONG).show()
        }, {
            Toast.makeText(this, "Falha ao buscar notas", Toast.LENGTH_LONG).show()
        })

        btnCadastrar.setOnClickListener{
            val intent = Intent(this, activity_cadastro::class.java)
            startActivity(intent)
        }
    }

    private fun configureList() {
        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter<Client>(this, android.R.layout.simple_list_item_1, clients)
        listView.adapter = adapter
    }
}