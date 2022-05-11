package com.example.laboratoriono5_6.View.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.model.pintura
import com.squareup.picasso.Picasso

class adapter_galeria(val GaleriaListener: galeriaListener):
                        RecyclerView.Adapter<adapter_galeria.GaleriaViewHolder>() {

    var listGaleria = ArrayList<pintura>()

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): GaleriaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_galeria, parent, false)
        return GaleriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: GaleriaViewHolder, position: Int) {

        val Pintura: pintura = listGaleria[position]
        holder.artistaPintura.text = Pintura.ArtistaPintura
        holder.tituloPintura.text =Pintura.TituloPintura
        holder.precioPintura.text = Pintura.PrecioPintura
        Picasso.get().load(Pintura.UrlPintura).into(holder.fotoPintura)
        holder.fotoPintura.setOnClickListener { view ->
            GaleriaListener.onGaleriaClicked(Pintura, position)
        }
    }

    override fun getItemCount(): Int {
        return listGaleria.size
    }

    fun updateData(data:List<pintura>)
    {
        listGaleria.clear()
        listGaleria.addAll(data)
        notifyDataSetChanged()
    }

    inner class GaleriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoPintura: ImageView
        val artistaPintura: TextView
        val tituloPintura: TextView
        val precioPintura: TextView

        init {
            fotoPintura = itemView.findViewById<View>(R.id.imgFotoPintura) as ImageView
            artistaPintura = itemView.findViewById<View>(R.id.tvNombreArtista) as TextView
            tituloPintura = itemView.findViewById<View>(R.id.tvTituloPintura) as TextView
            precioPintura = itemView.findViewById<View>(R.id.tvPrecioPintura) as TextView
        }
    }
}
