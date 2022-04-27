package com.example.laboratoriono5_6.View.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.model.artista

class adapter_artista(val ArtistaListener: artistaListener,
                      Artista: MutableList<artista>,
                      resource: Int,
                      context: Context?) :
    RecyclerView.Adapter<adapter_artista.ArtistaViewHolder>() {

    private val artista: MutableList<artista>
    private val resource:Int
    private val context: Context?
    init {
        this.artista = Artista
        this.resource = resource
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): ArtistaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return ArtistaViewHolder(view)
    }
    override fun onBindViewHolder(holder: ArtistaViewHolder, position: Int) {
        //
        val Artista: artista = artista[position]
        holder.artistaNombre.text = Artista.ArtistaNombre
        holder.artistaCategoria.text =Artista.ArtistaCategoria
        holder.artistaPais.text = Artista.ArtistaPais

        holder.itemView.setOnClickListener { view ->
            ArtistaListener.onArtistaClicked(Artista, position)
        }
    }
    override fun getItemCount(): Int {
        return artista.size
    }

    inner class ArtistaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // -----
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
