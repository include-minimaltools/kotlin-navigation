package com.example.laboratoriono5_6.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.View.adapter.adapter_galeria
import com.example.laboratoriono5_6.View.adapter.galeriaListener
import com.example.laboratoriono5_6.model.pintura

class fragmentGaleria : Fragment(), galeriaListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_galeria, container, false)

        val reciclergaleria=view.findViewById<View>(R.id.rvGaleria) as RecyclerView
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        reciclergaleria.layoutManager = linearmanager

        //-----
        val adapter = adapter_galeria(this, GetGaleria(), R.layout.item_galeria, context)
        reciclergaleria.adapter = adapter
        return view
    }

    override fun onGaleriaClicked(Galeria:pintura, position:Int)
    {
        NavHostFragment.findNavController(this).navigate(R.id.mfragmentGaleriaDetalle)
    }

    //Cargar obras de arte
    private fun GetGaleria(): MutableList<pintura>{
        var galeriaList: MutableList<pintura> = ArrayList()
        galeriaList.add(pintura("Haniel Herrera","1,600","https://artelista.s3.amazonaws.com/obras/big/3/5/5/1209702-607458d7c0c2a.jpg","Memories"))
        galeriaList.add(pintura("Jesús Cuenca","1,200", "https://artelista.s3.amazonaws.com/obras/big/1/6/4/1209582.jpg", "Rancio"))
        galeriaList.add(pintura("Pol Ledent", "1,600", "https://artelista.s3.amazonaws.com/obras/fichas/1/4/6/1209343.jpg", "Como en invierno"))
        galeriaList.add(pintura("Maribel Flores", "1,600", "https://artelista.s3.amazonaws.com/obras/big/7/4/1/1228034.jpg", "Blossom"))
        galeriaList.add(pintura("Nana Tchelidze", "575", "https://artelista.s3.amazonaws.com/obras/big/1/1/4/1228154.jpg", "El Puente"))
        return galeriaList
    }

}