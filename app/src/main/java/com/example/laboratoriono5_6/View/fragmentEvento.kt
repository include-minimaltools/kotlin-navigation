package com.example.laboratoriono5_6.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.View.adapter.adapter_artista
import com.example.laboratoriono5_6.View.adapter.adapter_evento
import com.example.laboratoriono5_6.View.adapter.eventoListener
import com.example.laboratoriono5_6.databinding.FragmentEventoBinding
import com.example.laboratoriono5_6.model.evento

class fragmentEvento : Fragment(), eventoListener {

    private var fbinding: FragmentEventoBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventoBinding.inflate(layoutInflater)
        val view = binding.root

        val recicleevento = binding.rvEvento
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        recicleevento.layoutManager = linearmanager

        val adapter = adapter_evento(this, GetEvento(), R.layout.item_evento, context)
        recicleevento.adapter = adapter

        return view
    }

    override fun onEventoClicked(Evento: evento, position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.mfragmentEventoUbicacion)
    }

    private fun GetEvento(): MutableList<evento> {
        val eventoList: MutableList<evento> = ArrayList()

        eventoList.add(evento("01:00 PM", "Villa Real vs Liverpool","Mar, 3/5"))
        eventoList.add(evento("01:00 PM", "Madrid vs Manchester City","Mar, 4/5"))
        eventoList.add(evento("01:00 PM", "Final","Mar, 28/5"))
        return eventoList
    }
}