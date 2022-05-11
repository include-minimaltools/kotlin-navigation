package com.example.laboratoriono5_6.View
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.databinding.FragmentEventoUbicacionBinding
import com.example.laboratoriono5_6.model.evento
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso

class fragmentUbicacionDet : DialogFragment() {
    //----------------
    var eventoLugar: String=""
    var eventoDireccion: String=""
    var eventoTelefono: String=""
    var eventoWebsite: String=""
    var eventoFoto: String=""
    var eventoHora: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ubicacion_det, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try{
            val toolbar: Toolbar = view.findViewById(R.id.toolubicaciondetalle)
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
            toolbar.navigationIcon= ContextCompat.getDrawable(view.context, R.drawable.ic_close)
            toolbar.setTitle("Detalle Ubicación")
            toolbar.setTitleTextColor(Color.WHITE)
            toolbar.setNavigationOnClickListener {
                dismiss()
                Navigation.findNavController(it).navigateUp()
            }

            val evento = arguments?.getSerializable("evento") as evento
            eventoHora = evento.Hora1
            eventoLugar = evento.EventoLugar
            eventoDireccion = evento.EventoDireccion
            eventoTelefono = evento.EventoTelefono
            eventoWebsite = evento.EventoWebSite
            eventoFoto = evento.EventoFoto


            val txtLugarEvento: MaterialTextView = view.findViewById(R.id.txtLugarEvento)
            val txtDireccionEvento: MaterialTextView = view.findViewById(R.id.txtDireccionEvento)
            val txtTelefonoEvento: MaterialTextView = view.findViewById(R.id.txtTelefonoEvento)
            val txtWebSiteEvento: MaterialTextView = view.findViewById(R.id.txtSitioWebEvento)
            val txtHoraEvento: MaterialTextView = view.findViewById(R.id.txtHoraEvento)
            val imgEvento: ImageView = view.findViewById(R.id.imgubicacion)

            txtLugarEvento.text = eventoLugar
            txtDireccionEvento.text = eventoDireccion
            txtTelefonoEvento.text = eventoTelefono
            txtWebSiteEvento.text = eventoWebsite
            txtHoraEvento.text = eventoHora
            Picasso.get().load(eventoFoto).into(imgEvento)

            txtWebSiteEvento.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(eventoWebsite)
                startActivity(intent)
            }
            txtTelefonoEvento.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${eventoTelefono}")
                }
                startActivity(intent)
            }
        }catch(e: Exception){
            e.printStackTrace()
        }
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}
