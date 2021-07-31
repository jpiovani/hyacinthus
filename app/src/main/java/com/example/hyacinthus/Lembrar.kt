package com.example.hyacinthus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import android.widget.EditText

class Lembrar : AppCompatActivity() {

    var tipo: String = ""
    lateinit var text: EditText
    var descricao: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tipoSelecionado()
        setContentView(R.layout.activity_lembrar)
    }

    fun tipoSelecionado(){
       tipo = intent.getStringExtra("tipo").toString()
    }

    fun cliqueBuscar (view: View){
        text = findViewById(R.id.editTextTextMultiLine)
        descricao = text.text.toString()
        val intent = Intent(this, ListaFilmeSeries::class.java)
        intent.putExtra("tipo", tipo)
        intent.putExtra("descricao", descricao)
        startActivity(intent)
    }




}