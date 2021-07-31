package com.example.hyacinthus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class OndeEncontrar : AppCompatActivity() {

    var webview: WebView? = null
    var onde: String = ""
    var titulo: String = ""
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onde_encontrar)
        recuperarNome()
        preencherTextView()
        webview = findViewById(R.id.webview)
        webview!!.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                    view?.loadUrl(url)
                    return true
                }
            }

            webview!!.getSettings().setJavaScriptEnabled(true)
            acessarUrl()

        }

    private fun recuperarNome() {
        titulo = intent.getStringExtra("titulo").toString()
    }

    private fun acessarUrl() {
       if(titulo.equals("Pousando no Amor")){
           webview!!.loadUrl("https://www.youtube.com/watch?v=IyA-JH5MNgE")
       }else if(titulo.equals("Tocando seu coração")){
           webview!!.loadUrl("https://www.youtube.com/watch?v=7Sdq9d3aN3g")
       }else if(titulo.equals("Gente Grande")){
           webview!!.loadUrl("https://www.youtube.com/watch?v=HKVve_VSz58")
       }else if(titulo.equals("A última Carta de Amor")){
           webview!!.loadUrl("https://www.youtube.com/watch?v=AfwAAH0sQEQ")
       }
    }

    private fun preencherTextView() {
        onde = intent.getStringExtra("ondeEncontrar").toString()
        text = findViewById(R.id.textView5)
        text.setText("Vai la na(o) " + onde + " maratonar :)")
    }

    fun cliqueVoltar (view: View){
        Toast.makeText(this, "Saudades de outro?", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
