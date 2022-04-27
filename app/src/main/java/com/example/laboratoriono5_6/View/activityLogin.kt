package com.example.laboratoriono5_6.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.laboratoriono5_6.databinding.ActivityLoginBinding

class activityLogin : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun onClickArteLista(view: View) {
        val intent = Intent(this, activityMenu::class.java)
        startActivity(intent)
    }

    fun onClickCrearCuenta(view: View){
        val intent = Intent(this, activityCrearCuenta::class.java)
        startActivity(intent)
    }
}