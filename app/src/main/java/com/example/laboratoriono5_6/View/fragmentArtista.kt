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
        artistaList.add(artista("Robert Lewandoski","Bayern Munich","Alemania"))
        artistaList.add(artista("Cristiano Ronaldo","Manchester United", "Portugal"))
        artistaList.add(artista("Peter Cech", "Manchester United", "Alemania"))
        artistaList.add(artista("Neymar Junior", "Paris Saint-Germain", "Brasil"))
        artistaList.add(artista("Harry Kane", "Tottenham", "Inglaterra"))
        artistaList.add(artista("Eden Hazard","Real Madrid","Alemania"))
        artistaList.add(artista("Vinicius Junior","Real Madrid", "Brasil"))
        artistaList.add(artista("Lionel Messi", "Paris Saint-Germain", "Argentina"))
        artistaList.add(artista("Kylian Mbappe", "Parins Saint-Germain", "Francia"))
        artistaList.add(artista("Adama Toure", "FC Barcelona", "Inglaterra"))
        return artistaList
    }
}