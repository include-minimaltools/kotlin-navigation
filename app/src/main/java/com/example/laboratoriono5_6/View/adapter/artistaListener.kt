package com.example.laboratoriono5_6.View.adapter
import com.example.laboratoriono5_6.model.artista

interface artistaListener {
    fun onArtistaClicked(Artista: artista, position: Int)
}