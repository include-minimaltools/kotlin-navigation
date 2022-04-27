package com.example.laboratoriono5_6.View

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.databinding.FragmentArtistaDetalleBinding

class fragmentArtistaDetalle : DialogFragment() {

    private var fbinding: FragmentArtistaDetalleBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentArtistaDetalleBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btnAcercaDe.setOnClickListener{
            if(binding.tvDescripcionAcerca.visibility==View.VISIBLE){
                binding.tvDescripcionAcerca.visibility = View.INVISIBLE
                binding.btnAcercaDe.background = ContextCompat.getDrawable(view.context, R.drawable.ic_down)
                AnimationUtils.loadAnimation(view.context, androidx.appcompat.R.anim.abc_fade_in).also{ animboton ->
                    binding.tvDescripcionAcerca.startAnimation(animboton)
                }
            }else{
                binding.tvDescripcionAcerca.visibility = View.VISIBLE
                binding.btnAcercaDe.background = ContextCompat.getDrawable(view.context, R.drawable.ic_up)
                AnimationUtils.loadAnimation(view.context, androidx.appcompat.R.anim.abc_slide_in_bottom).also{ animboton ->
                    binding.tvDescripcionAcerca.startAnimation(animboton)
                }
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.tooldetalleartista

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle("Artista")
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