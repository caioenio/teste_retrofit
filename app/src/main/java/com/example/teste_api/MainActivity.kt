package com.example.teste_api

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit.client.ClientWeb
import retrofit.model.Client

class MainActivity : AppCompatActivity() {

    private val clients: MutableList<Client> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.listView)
        listView.adapter = CustomAdapter(this)

        btnCadastrar.setOnClickListener{
            val intent = Intent(this, activity_cadastro::class.java)
            startActivity(intent)
        }
    }

    fun Listagem(){
        val clients: MutableList<Client> = mutableListOf()
        ClientWeb().list({
            clients.addAll(it)
            Toast.makeText(this, "Trouxe", Toast.LENGTH_LONG).show()
        }, {
            Toast.makeText(this, "Falha ao buscar notas", Toast.LENGTH_LONG).show()
        })
    }

    private class CustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return 5
        }

        override fun getItemId(postition: Int): Long {
            return postition.toLong()
        }

        override fun getItem(postition: Int): Any {
            return "Test String"
        }

        override fun getView(postition: Int, convertView: View?, p2: ViewGroup?): View {
            val textView = TextView(mContext)
            textView.text = "testando"
            return textView
        }
    }
}