package com.example.laboratoriono5_6.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.databinding.ActivityLoginBinding
import com.example.laboratoriono5_6.databinding.ActivityMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class activityMenu : AppCompatActivity() {
    private lateinit var binding:ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val menuartelista:BottomNavigationView = findViewById(R.id.bottomNavMenu)
        setupWithNavController(menuartelista, findNavController(this, R.id.frag_navgraph))
    }
}