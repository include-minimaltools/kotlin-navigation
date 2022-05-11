package com.example.laboratoriono5_6.View.adapter
import com.example.laboratoriono5_6.model.evento

interface eventoListener {
    fun onEventoClicked(Evento: evento, position: Int)
}