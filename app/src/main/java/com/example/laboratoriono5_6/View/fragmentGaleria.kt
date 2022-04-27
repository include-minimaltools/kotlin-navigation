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
        var galeriaList: MutableList<pintura> = arrayListOf(
            pintura("City 4 - 3 Madrid","1,600","https://as01.epimg.net/futbol/imagenes/2022/04/26/champions/1650948733_580917_1651005910_noticia_normal_recorte1.jpg","Partido de Ida"),
            pintura("Liverpool 3 - 3 Benfica", "1243", "https://futbolenlinea.club/wp-content/uploads/2022/04/10-cosas-clave-que-debes-saber-antes-del-Benfica-vs.jpg", "Partido de Ida"),
            pintura("Madrid 2 - 3 Chelsea", "1453", "https://phantom-marca.unidadeditorial.es/d7b8216569c07bbc3bef9f65b0c2f2d2/resize/1320/f/jpg/assets/multimedia/imagenes/2022/04/12/16497917794736.jpg", "Partido de Vuelta"),
            pintura("Atletico 0 - 0 City", "650", "https://depor.com/resizer/MCe7HI2WXY-suURrO3Z4cpVm-5g=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/ZA22T2A5WFBEVIXBMIRTP4MRYE.jpg", "Partido de Vuelta")
        )
        return galeriaList
    }

}