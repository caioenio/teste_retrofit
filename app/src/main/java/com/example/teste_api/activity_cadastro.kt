package com.example.teste_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import retrofit.client.ClientWeb
import retrofit.model.Client

class activity_cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        BtnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        BtnCadastrar.setOnClickListener(){
            this.insert {  }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun insert(created: (createdClient: Client) -> Unit) {
        val name: String = nome.text.toString();
        val mail: String = email.text.toString();
        val client = Client(nome = name, email = mail)

        ClientWeb().insert(client, {
            created(it)
            Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
        }, {
            Toast.makeText(this, "Falha ao realizar cadastro", Toast.LENGTH_LONG).show()
        })
    }
}
