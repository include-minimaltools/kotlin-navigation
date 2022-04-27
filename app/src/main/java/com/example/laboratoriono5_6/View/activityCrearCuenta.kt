package com.example.laboratoriono5_6.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import android.widget.Toast
import com.example.laboratoriono5_6.databinding.ActivityCrearCuentaBinding

class activityCrearCuenta : AppCompatActivity() {

    private lateinit var binding:ActivityCrearCuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolCrearCuenta
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Crear cuenta")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.btnCrearCuenta.setOnClickListener{
            /*var temp = emailFocusListener()

            if(temp == null){
                finish()
            }else
            {
                return@setOnClickListener
            }*/
            finish()
        }
    }

    /*private fun emailFocusListener(){
        binding.tvEmailCuenta.setOnFocusChangeListener(){_, focused ->
            if(!focused){
                binding.tvEmailCuenta.text = validEmail()
            }
        }
    }

    private fun validEmail(): Editable? {
        val emailText = binding.tvEmailCuenta.text.toString()

        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            Toast.makeText(this, "Email invalido", Toast.LENGTH_SHORT).show();
        }
        return null
    }*/
}