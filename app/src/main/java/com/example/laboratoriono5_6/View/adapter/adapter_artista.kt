package com.example.laboratoriono5_6.View.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.model.artista

class adapter_artista(val ArtistaListener: artistaListener):
                        RecyclerView.Adapter<adapter_artista.ArtistaViewHolder>() {

    var listartista = ArrayList<artista>()
    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): ArtistaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artista, parent, false)
        return ArtistaViewHolder(view)
    }
    override fun onBindViewHolder(holder: ArtistaViewHolder, position: Int) {
        //
        val Artista: artista = listartista[position]
        holder.artistaNombre.text = Artista.ArtistaNombre
        holder.artistaCategoria.text =Artista.ArtistaCategoria
        holder.artistaPais.text = Artista.ArtistaPais

        holder.itemView.setOnClickListener { view ->
            ArtistaListener.onArtistaClicked(Artista, position)
        }
    }
    override fun getItemCount(): Int {
        return listartista.size
    }

    fun updateData(data:List<artista>)
    {
        listartista.clear()
        listartista.addAll(data)
        notifyDataSetChanged()
    }

    inner class ArtistaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artistaNombre: TextView
        val artistaCategoria: TextView
        val artistaPais: TextView

        init {
            artistaNombre = itemView.findViewById<View>(R.id.tvArtistaNombre) as TextView
            artistaCategoria = itemView.findViewById<View>(R.id.tvtArtistaCategoria) as TextView
            artistaPais = itemView.findViewById<View>(R.id.tvArtistaPais) as TextView
        }
    }
}
