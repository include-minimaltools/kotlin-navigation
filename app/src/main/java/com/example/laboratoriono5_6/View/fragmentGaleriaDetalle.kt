package com.example.laboratoriono5_6.View

import android.app.ActionBar
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.example.laboratoriono5_6.databinding.FragmentGaleriaDetalleBinding

class fragmentGaleriaDetalle : DialogFragment() {

    private var _binding: FragmentGaleriaDetalleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGaleriaDetalleBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.tooldetallegaleria

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle("Arte")
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