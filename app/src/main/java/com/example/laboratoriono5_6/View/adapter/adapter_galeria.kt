package com.example.laboratoriono5_6.View.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.model.pintura
import com.squareup.picasso.Picasso

class adapter_galeria (val GaleriaListener: galeriaListener,
                       Galeria: MutableList<pintura>,
                       resource:Int,
                       context: Context?) :
    RecyclerView.Adapter<adapter_galeria.ViewHolder>() {

    //---
    private val galeria:MutableList<pintura>
    private val resource:Int
    private val context:Context?

    init {
        this.galeria= Galeria
        this.resource= resource
        this.context= context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //----
        val fotoPintura:ImageView
        val artistaPintura: TextView
        val tituloPintura:TextView
        val precioPintura:TextView

        init {
            // Define click listener for the ViewHolder's View.
            fotoPintura = itemView.findViewById<View>(R.id.imgFotoPintura) as ImageView
            artistaPintura = itemView.findViewById<View>(R.id.tvNombreArtista) as TextView
            tituloPintura = itemView.findViewById<View>(R.id.tvTituloPintura) as TextView
            precioPintura = itemView.findViewById<View>(R.id.tvPrecioPintura) as TextView
        }
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //
        val Pintura:pintura = galeria[position]
        holder.artistaPintura.text = Pintura.ArtistaPintura
        holder.tituloPintura.text = Pintura.TituloPintura
        holder.precioPintura.text = Pintura.PrecioPintura
        Picasso.get().load(Pintura.UrlPintura).into(holder.fotoPintura)
        holder.fotoPintura.setOnClickListener{
            GaleriaListener.onGaleriaClicked(Pintura, position)
        }
    }

    override fun getItemCount():Int{
        return galeria.size
    }

}