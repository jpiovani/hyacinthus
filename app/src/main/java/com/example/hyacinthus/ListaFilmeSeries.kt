package com.example.hyacinthus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class ListaFilmeSeries : AppCompatActivity() {
    
    var tipo: String = ""
    var titulo: String = ""
    var palavrasChaves: String = ""
    var descricao: String = ""
    var sinopse: String = ""
    var ondeEncontrar: String = ""
    lateinit var textTitulo: TextView
    lateinit var textSinopse: TextView
    lateinit var imagemView: ImageView
   // var imagem: Int = R.mipmap.ic_launcher
    var caminho: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filme_series)
        tipo = intent.getStringExtra("tipo").toString()
        descricao = intent.getStringExtra("descricao").toString()
        verificarPalavrasChaves_Imagem(descricao)
        val db = DatabaseManager(this, "filmeSeries")
        val cursor = db.listaFilmeSeries(tipo,palavrasChaves)
        if(cursor.count > 0){
            cursor.moveToFirst()
            titulo = cursor.getString(cursor.getColumnIndex("NOME"))
            sinopse = cursor.getString(cursor.getColumnIndex("DESCRICAO"))
            textSinopse = findViewById(R.id.textView4)
            textSinopse.setText(sinopse.toString())
            textTitulo = findViewById(R.id.textView2)
            textTitulo.setText(titulo.toString())
            imagemView = findViewById(R.id.imageView3)
      // imagemView.setImageResource(imagem)
            Glide.with(this).load(caminho).into(imagemView!!)
        }else{
            retornaErro()
        }
    }

    private fun retornaErro() {
        Toast.makeText(this, "Desculpe, tente novamente", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun verificarPalavrasChaves_Imagem (descricao: String){
        if(descricao.contains("militar")){
            palavrasChaves = "romance#militar#Coreia do Sul#Coreia do Norte#presidente#desaparecida#queda"
            caminho = "https://mixdeseries.com.br/wp-content/uploads/2021/07/Pousando-no-Amor-2-temporada.jpg"
            ondeEncontrar = "Netflix"
        }else if(descricao.contains("advogado")){
            palavrasChaves = "romance#atriz#advogado#secretaria#coracao"
            caminho = "https://6.viki.io/image/0ed950ddf07d47e2a71665c28e8c433e.png?x=b&a=0x0"
            ondeEncontrar = "Netflix e Viki"
        }else if(descricao.contains("aventura")){
            palavrasChaves = "aventura#diversão#amigos#passado#basketball"
            caminho = "https://lh3.googleusercontent.com/-mftx6dCuxXU/X7P3qKhZxxI/AAAAAAAAE8c/xQRutb_swToue1JaI4KVLqtGp4ohLDwJQCLcBGAsYHQ/s1600/1605629861253757-0.png"
            ondeEncontrar = "Netflix"
        }else if (descricao.contains("cartas")){
            palavrasChaves = "romance#reporter#secreto#cartas#misterio"
            caminho = "https://occ-0-1068-92.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABcHn6agR_jTbbW5BIyfhDGodY6Wo6MiTNb-MqIz_P-ZiikhAn8QLfK3EIQH8RflYBBIIa4R5KlWgl6C2V9XnB6gbM9wJ.jpg?r=118"
            ondeEncontrar = "Netflix"
        }

    }

    fun cliqueNaoEesse (view: View){
        Toast.makeText(this, "Tente novamente", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun cliqueEesse (view: View){
        Toast.makeText(this, "Sucesso!!!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, OndeEncontrar::class.java)
        intent.putExtra("ondeEncontrar", ondeEncontrar)
        intent.putExtra("titulo", titulo)
        startActivity(intent)
    }
}