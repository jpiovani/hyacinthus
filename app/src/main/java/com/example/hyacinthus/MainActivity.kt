package com.example.hyacinthus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {


    var tipo: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        criacaoBanco()
        setContentView(R.layout.activity_main)
    }

    fun criacaoBanco(){
        val db = DatabaseManager(this, "filmeSeries")

            db.insereFilmeSeries(1, "Pousando no Amor", "Asiatico",
                "Serie que apresenta a historia de uma executiva sul-coreana que cai " +
                        "durante um voo de parapente na zona desmilitarizada da Coreia do norte e é " +
                        "encontrada por um oficial de lá", "romance#militar#Coreia do Sul#Coreia do Norte#presidente#desaparecida#queda")
            db.insereFilmeSeries(2, "Tocando seu coração", "Asiatico",
                "Serie que apresenta a historia de uma atriz que se envolve em um " +
                        "escândalo e para se recuperar aceita ser secretária de um advogado " +
                        "para se preparar para o novo papel", "romance#atriz#advogado#secretaria#coracao")
            db.insereFilmeSeries(3, "A última Carta de Amor", "Americano",
                "Depois de encontrar uma série de cartas de amor antigas, uma reporter " +
                        "decide resolver o mistério de um romance secreto", "romance#reporter#secreto#cartas#misterio")
            db.insereFilmeSeries(4, "Gente Grande", "Americano",
                "Cinco amigos se reencontram em uma casa de campo após 30 anos ",
                "aventura#diversão#amigos#passado#basketball")

    }

    fun cliqueAsi(view: View) {
        tipo = "Asiatico"
        val intent = Intent(this, Lembrar::class.java)
        intent.putExtra("tipo", tipo)
        startActivity(intent)
    }
    fun cliqueAme(view: View) {
        tipo = "Americano"
        val intent = Intent(this, Lembrar::class.java)
        intent.putExtra("tipo", tipo)
        startActivity(intent)
    }
}