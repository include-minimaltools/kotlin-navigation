package com.example.laboratoriono5_6.View.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.model.evento

class adapter_evento(val EventoListener: eventoListener):
                        RecyclerView.Adapter<adapter_evento.EventoViewHolder>() {

    var listevento = ArrayList<evento>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {

        val Evento: evento = listevento[position]
        holder.Hora1.text = Evento.Hora1
        holder.Evento.text = Evento.EventoLugar
        holder.EventoCategoria.text = Evento.EventoDireccion

        holder.itemView.setOnClickListener { view ->
            EventoListener.onEventoClicked(Evento, position)
        }
    }

    override fun getItemCount(): Int {
        return listevento.size
    }

    fun updateData(data:List<evento>)
    {
        listevento.clear()
        listevento.addAll(data)
        notifyDataSetChanged()
    }

    inner class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Hora1: TextView
        val Evento: TextView
        val EventoCategoria: TextView

        init {
            Hora1 = itemView.findViewById<View>(R.id.tvEventoHora1) as TextView
            Evento = itemView.findViewById<View>(R.id.tvEvento) as TextView
            EventoCategoria = itemView.findViewById<View>(R.id.tvEventoCategoria) as TextView
        }
    }
}