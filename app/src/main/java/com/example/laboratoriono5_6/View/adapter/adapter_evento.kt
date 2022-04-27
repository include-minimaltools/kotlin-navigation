package com.example.laboratoriono5_6.View.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.model.evento
import com.squareup.picasso.Picasso


class adapter_evento(val eventoListener: eventoListener,
                    Evento:MutableList<evento>,
                    resource: Int,
                    context: Context?): RecyclerView.Adapter<adapter_evento.ViewHolder>() {
    private val evento: MutableList<evento>
    private val resource: Int
    private val context: Context?

    init {
        this.evento = Evento
        this.resource = resource
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val Evento: evento = evento[position]
        holder.eventoHora.text = Evento.EventoHora
        holder.eventoNombre.text = Evento.EventoNombre
        holder.eventoPintura.text = Evento.EventoPintura

        holder.itemView.setOnClickListener { view ->
            eventoListener.onEventoClicked(Evento, position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventoHora: TextView
        val eventoNombre: TextView
        val eventoPintura: TextView

        init {
            eventoHora = itemView.findViewById<View>(R.id.tvEventoHora1) as TextView
            eventoNombre = itemView.findViewById<View>(R.id.tvEvento) as TextView
            eventoPintura = itemView.findViewById<View>(R.id.tvEventoCategoria) as TextView
        }
    }

    override fun getItemCount(): Int {
        return evento.size
    }
}