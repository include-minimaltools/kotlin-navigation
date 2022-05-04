package com.example.laboratoriono5_6.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.laboratoriono5_6.databinding.ActivityCrearCuentaBinding
import com.google.firebase.auth.FirebaseAuth

class activityCrearCuenta : AppCompatActivity() {

    private lateinit var binding:ActivityCrearCuentaBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val toolbar: Toolbar = binding.toolCrearCuenta
        setSupportActionBar(toolbar)

        supportActionBar!!.setTitle("Crear cuenta")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.btnCrearCuenta.setOnClickListener {
            if (valida().equals(true)) {
                addCuentaUsuario()
                Toast.makeText(this, "El usuario ha sido creado", Toast.LENGTH_SHORT).show()
                        finish()
            }
        }
    }
    
    fun addCuentaUsuario()
    {
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.createUserWithEmailAndPassword(binding.tvEmailCuenta.text.toString(), binding.tvPasswordCuenta.text.toString()).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "El usuario ha sido creado", Toast.LENGTH_SHORT).show()
                            finish()
                } else {
                    Toast.makeText(this, "El usuario no ha sido creado", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun valida(): Boolean {
        try {
            var validaok = false

            if (binding.tvEmailCuenta.length() == 0)
            {
                binding.tvEmailCuenta.requestFocus()
                binding.tvEmailCuenta.setError("Email es un valor requerido")
                return validaok
            }

            if(binding.tvEmailCuenta.text?.contains("@") != true){
                binding.tvEmailCuenta.requestFocus()
                binding.tvEmailCuenta.setError("El Email necesita el signo '@'")
                return validaok
            }

            if (binding.tvPasswordCuenta.text?.length?.equals(0)!! || binding.tvPasswordCuenta.text!!.length < 6 || binding.tvPasswordCuenta.text!!.length > 8 ) {
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("Debe ingresar una contraseña valida")
                    return validaok
            }
            if (binding.tvConfirmarContraseniaCuenta.text?.length?.equals(0)!! || binding.tvConfirmarContraseniaCuenta.text!!.length < 6 || binding.tvConfirmarContraseniaCuenta.text!!.length > 8 )
            {
                binding.tvConfirmarContraseniaCuenta.requestFocus()
                binding.tvConfirmarContraseniaCuenta.setError("Debe ingresar la confirmación de contraseña")
                    return validaok
            }

            val strpassword: String = if (binding.tvConfirmarContraseniaCuenta.text != null) binding.tvPasswordCuenta.text.toString() else ""
            val strpasswordconfirmar:String = if (binding.tvConfirmarContraseniaCuenta.text != null) binding.tvConfirmarContraseniaCuenta.text.toString() else ""

            if (!strpassword.equals(strpasswordconfirmar))
            {
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("El Password y la confirmación deben coincidir")
                return validaok
            }

            validaok = true
            return validaok
        } catch (e: Exception) {
            e.message?.let { Log.e("Error en valida", it) }
            return false
        }
    }
}