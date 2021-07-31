package com.example.hyacinthus

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String?) : SQLiteOpenHelper(context,name,null,1)  {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("CREATE TABLE FILMES_SERIES(\n" +
                "\tID INT NOT NULL,\n" +
                "\tNOME VARCHAR(50),\n" +
                "\tTIPO VARCHAR(15),\n" +
                "\tDESCRICAO VARCHAR(100),\n" +
                "\tPALAVRAS_CHAVES VARCHAR(70),\n" +
                "\tPRIMARY KEY (ID)\n" +
                "\t);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS FILMES_SERIES")

        p0?.execSQL("CREATE TABLE FILMES_SERIES(\n" +
                "\tID INT NOT NULL,\n" +
                "\tNOME VARCHAR(50),\n" +
                "\tTIPO VARCHAR(15),\n" +
                "\tDESCRICAO VARCHAR(100),\n" +
                "\tPALAVRAS_CHAVES VARCHAR(70),\n" +
                "\tPRIMARY KEY (ID)\n" +
                "\t);")
    }

    fun insereFilmeSeries(id: Int, nome: String, tipo: String, descricao: String, palavrasChaves: String){
        var db = this.writableDatabase

        var cv = ContentValues()

        cv.put("ID",id)
        cv.put("NOME",nome)
        cv.put("TIPO",tipo)
        cv.put("DESCRICAO",descricao)
        cv.put("PALAVRAS_CHAVES",palavrasChaves)

        db.insert("FILMES_SERIES","ID",cv)
    }

    fun listaFilmeSeries(tipo: String, palavrasChaves: String): Cursor {

        var db = this.readableDatabase
        var cur = db.rawQuery("select nome, descricao from filmes_series where " +
                    "tipo='" + tipo + "' and palavras_chaves='" + palavrasChaves + "'", null)
        return cur
    }

    fun removeFilmeSeries(id: Int){
        var db = this.writableDatabase
        db.delete("FILMES_SERIES", "ID=$id",null)
    }
}