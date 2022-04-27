package com.example.laboratoriono5_6.View

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.example.laboratoriono5_6.databinding.FragmentEventoUbicacionBinding

class fragmentEventoUbicacion : DialogFragment() {

    private var fbinding: FragmentEventoUbicacionBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventoUbicacionBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.tooleventoubicacion

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle("Ubicacion")
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener{
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}