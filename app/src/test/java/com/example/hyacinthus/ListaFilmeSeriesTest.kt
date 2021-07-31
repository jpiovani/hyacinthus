package com.example.hyacinthus

import junit.framework.TestCase
import org.junit.Test

class ListaFilmeSeriesTest : TestCase() {

    @Test
    fun testVerificarPalavrasChaves_Imagem() {
        val result = verificarPalavrasChaves_Imagem("Serie de uma executiva que cai em uma zona " +
                "desmilitarizada e é encontrada por um militar")
        assertEquals(result.result, Result.PousandoNoAmor)
    }

}