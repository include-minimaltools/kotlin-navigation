package com.example.laboratoriono5_6.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratoriono5_6.model.Account
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.databinding.ActivityLoginBinding

class activityLogin : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    private val accounts:List<Account> = listOf(
        Account("gabrielortizamador@gmail.com", "1234"),
        Account("luispinedajoseph@gmail.com", "1234"),
        Account("l@gmail.com", "1234")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun validateValues() : Boolean
    {
        val txtUser = findViewById<EditText>(R.id.tvUserName)
        val txtPassword = findViewById<EditText>(R.id.password)


            if(txtUser.text.isEmpty() || txtPassword.text.isEmpty())
                throw Error("No se admiten campos vacios")

            if(!txtUser.text.contains("@"))
                throw Error("Correo electronico invalido")

            if(txtPassword.text.length < 3)
                throw Error("La contraseña debe tener al menos 8 caracteres")

            return true
    }

    fun haveAccount() : Boolean {
        val txtUser = findViewById<EditText>(R.id.tvUserName)
        val txtPassword = findViewById<EditText>(R.id.password)

        accounts.forEach {account ->
            if(account.password.contentEquals(txtPassword.text) && account.email.contentEquals(txtUser.text))
                return true
        }

        return false
    }

    fun onClickArteLista(view: View) {
        try
        {
            if(!validateValues())
                return

            if(!haveAccount())
                throw Error("Usuario o Contraseña incorrecta")

            val intent = Intent(this, activityMenu::class.java)
            startActivity(intent)
        }
        catch (ex: Error) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }

    fun onClickCrearCuenta(view: View){
        val intent = Intent(this, activityCrearCuenta::class.java)
        startActivity(intent)
    }
}