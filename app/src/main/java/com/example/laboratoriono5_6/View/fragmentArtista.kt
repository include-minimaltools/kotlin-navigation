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
import com.example.laboratoriono5_6.View.adapter.artistaListener
import com.example.laboratoriono5_6.databinding.FragmentArtistaBinding
import com.example.laboratoriono5_6.model.artista

class fragmentArtista : Fragment(), artistaListener {

    private var fbinding: FragmentArtistaBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentArtistaBinding.inflate(layoutInflater)
        val view = binding.root

        val recicleartista = binding.rvArtista
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        recicleartista.layoutManager = linearmanager

        val adapter = adapter_artista(this, GetArtista(), R.layout.item_artista, context)
        recicleartista.adapter = adapter

        return view
    }

    override fun onArtistaClicked(Artista: artista, position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.mfragmentArtistaDetalle)
    }


    private fun GetArtista(): MutableList<artista>{
        val artistaList: MutableList<artista> = ArrayList()
        artistaList.add(artista("Haniel Herrera","Oleo","Nicaragua"))
        artistaList.add(artista("Jesús Cuenca","Grafito", "Costa Rica"))
        artistaList.add(artista("Pol Ledent", "Acrílico", "Guatemala"))
        artistaList.add(artista("Maribel Flores", "Arte plástico", "Honduras"))
        artistaList.add(artista("Nana Tchelidze", "Oleo", "El Salvador"))
        artistaList.add(artista("Lola Cortés","Acrílico","Nicaragua"))
        artistaList.add(artista("María López","Grafito", "Chile"))
        artistaList.add(artista("Verónica Guardado", "Acrílico", "Nicaragua"))
        artistaList.add(artista("Johnny Flores", "Arte plástico", "Nicaragua"))
        artistaList.add(artista("Rosa Manzanares", "Grafito", "Nicaragua"))
        artistaList.add(artista("Lola Cortés","Acrílico","Nicaragua"))
        artistaList.add(artista("María López","Grafito", "Chile"))
        artistaList.add(artista("Verónica Guardado", "Acrílico", "Nicaragua"))
        artistaList.add(artista("Johnny Flores", "Arte plástico", "Nicaragua"))
        artistaList.add(artista("Rosa Manzanares", "Grafito", "Nicaragua"))
        return artistaList
    }
}