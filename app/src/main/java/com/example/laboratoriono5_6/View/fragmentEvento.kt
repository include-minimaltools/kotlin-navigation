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
import com.example.laboratoriono5_6.View.adapter.adapter_evento
import com.example.laboratoriono5_6.View.adapter.eventoListener
import com.example.laboratoriono5_6.Viewmodel.eventoViewmodel
import com.example.laboratoriono5_6.databinding.FragmentEventoBinding
import com.example.laboratoriono5_6.model.evento

class fragmentEvento : Fragment(), eventoListener {

    private var fbinding: FragmentEventoBinding? = null
    private val binding get() = fbinding!!
    private lateinit var eventoAdapter: adapter_evento
    private lateinit var viewModel: eventoViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventoBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(eventoViewmodel::class.java)
        viewModel.refresh()
        eventoAdapter = adapter_evento(this)

        binding.rvEvento.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = eventoAdapter
        }
        observeViewModel()
        return view
    }

    private fun observeViewModel() {
        viewModel.listEvento.observe(viewLifecycleOwner, Observer<List<evento>> { evento ->
            eventoAdapter.updateData(evento)
        })
    }

    override fun onEventoClicked(Evento: evento, position: Int) {
        val bundle = bundleOf("eventos" to Evento)
        NavHostFragment.findNavController(this).navigate(R.id.mfragmentEventoUbicacion, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    /*private fun GetEvento(): MutableList<evento> {
        val eventoList: MutableList<evento> = ArrayList()
        eventoList.add(evento("09:00AM","Universidad Nacional de Ingeniería (UNI)", "Partido de Futbol", "Managua, Nicaragua", 12.132217502029128, -86.26987020617783, "22700973","https://www.uni.edu.ni", "https://lh5.googleusercontent.com/p/AF1QipPBc_8YcZrVDAYJQVNxsFShaUBt1fMXaP524MSk=w408-h306-k-no" ))
        eventoList.add(evento("10:00AM","Palacio Nacional Nicaragua", "Pintura en Oleo", "Managua,Nicaragua",12.155753468843768, -86.27181158240545, "22700973","https://www.uni.edu.ni", "https://lh5.googleusercontent.com/p/AF1QipPSqNF77DzZ4u7OR7td8djndBhv2oZIBqpZ98Sr=w408-h306-k-no" ))
        eventoList.add(evento("11:00AM","Catedral de León", "Acrílico", "León, Nicaragua",12.435324873993144, -86.87811227445178, "22700973","https://www.uni.edu.ni", "https://lh5.googleusercontent.com/p/AF1QipNs-Imj8nYgJGnGzSX3RBTyF0Wb8JUgrDEPzRAZ=w408-h306-k-no" ))
        eventoList.add(evento("18:00PM","Centro Cultural Mercado de Artesanías", "Acrílico", "Masaya, Nicaragua",11.974114551016928, -86.09356818480153, "22700973","https://www.uni.edu.ni", "https://lh5.googleusercontent.com/p/AF1QipMKisJvZoWZRi2fwisVPJ4nedCTavDfhD_l1gOK=w426-h240-k-no\n" ))
        eventoList.add(evento("20:00PM","Hispamer", "Oleo", "Managua, Nicaragua",12.126254938201553, -86.27016318794827, "+505 22700973","https://www.uni.edu.ni", "https://nuevaya.com.ni/wp-content/uploads/2021/02/UNI-RECIENTO-FRENTE-ACTUAL.jpg.webp" ))
        eventoList.add(evento("08:00AM","Galerías Santo Domingo", "Grafito", "Managua, Nicaragua",12.103822159374769, -86.24928744561913, "+505 22700973","http://www.galerias.com.ni", "https://lh5.googleusercontent.com/p/AF1QipMJLS9UryEMUMehmqyw9RdkE2x09fALdQcHZmGd=w520-h240-k-no" ))
        eventoList.add(evento("09:30AM","Centro de Arte Fundación Ortiz Gurdián", "Oleo", "León, Nicaragua",12.435021697165867, -86.8819260032871, "+505 22700973","http://www.fundacionortizgurdian.org", "https://lh5.googleusercontent.com/p/AF1QipNnjAmM3pSJF3lQBM_izBl2NW2FPnx7KeT9hehA=w426-h240-k-no" ))
        eventoList.add(evento("10:00PM","Gabriel House", "Party", "Leche Agria Muu, Managua",12.1205678, -86.2099729, "+505 22700973","http://www.uni.edu.ni", "https://elcomercio.pe/resizer/pfVziOV4X8Vu9nwknDc-oNItlB8=/1200x900/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6Y2EDIISGFGVFANEVDCR5LCG34.jpg" ))
        return eventoList
    }*/
}