package com.example.laboratoriono5_6.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.View.adapter.adapter_galeria
import com.example.laboratoriono5_6.View.adapter.galeriaListener
import com.example.laboratoriono5_6.Viewmodel.galeriaViewmodel
import com.example.laboratoriono5_6.databinding.FragmentGaleriaBinding
import com.example.laboratoriono5_6.model.pintura

class fragmentGaleria : Fragment(), galeriaListener {

    private var fbinding: FragmentGaleriaBinding? = null
    private val binding get() = fbinding!!
    private lateinit var galeriaAdapter: adapter_galeria
    private lateinit var viewModel: galeriaViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentGaleriaBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(galeriaViewmodel::class.java)
        viewModel.refresh()
        galeriaAdapter = adapter_galeria(this)

        binding.rvGaleria.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = galeriaAdapter
        }
        observeViewModel()
        return view
    }

    private fun observeViewModel() {
        viewModel.listGaleria.observe(viewLifecycleOwner, Observer<List<pintura>> {pintura ->
            galeriaAdapter.updateData(pintura)
        })
    }

    override fun onGaleriaClicked(Galeria: pintura, position: Int) {
        val bundle = bundleOf("galerias" to Galeria)
        NavHostFragment.findNavController(this).navigate(R.id.mfragmentGaleriaDetalle, bundle)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}