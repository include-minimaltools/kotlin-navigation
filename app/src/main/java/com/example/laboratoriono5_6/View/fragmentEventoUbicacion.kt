package com.example.laboratoriono5_6.View
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.databinding.FragmentEventoUbicacionBinding
import com.example.laboratoriono5_6.model.evento
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class fragmentEventoUbicacion : DialogFragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    var latitud: Double = 0.0
    var longitud: Double=0.0
    var eventoLugar: String=""

    var fbinding: FragmentEventoUbicacionBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventoUbicacionBinding.inflate(inflater, container, false)

        val evento = arguments?.getSerializable("eventos") as evento
        latitud = evento.EventoLatitud
        longitud = evento.EventoLongitud
        eventoLugar = evento.EventoLugar

        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = view.findViewById(R.id.tooleventoubicacion)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle("Ubicación")
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        val zoom=16f
        val centerMap = LatLng(latitud, longitud)

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap,zoom))
        val centerMark= LatLng(latitud, longitud)
        val markerOptions = MarkerOptions()
        markerOptions.position(centerMark)
        markerOptions.title(eventoLugar)

        val bitmapDraw = context?.applicationContext?.let{ ContextCompat.getDrawable(it, R.drawable.ic_localizacion)} as BitmapDrawable
        val smallMarker= Bitmap.createScaledBitmap(bitmapDraw.bitmap, 150, 150, false)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))

        googleMap.addMarker(markerOptions)
        googleMap.setOnMarkerClickListener(this)
        //---------------
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_style))
    }
    override fun onMarkerClick(googleMap: Marker): Boolean {
        findNavController(this).navigate(R.id.mfragmentUbicacionDet)
        return true
    }
}
