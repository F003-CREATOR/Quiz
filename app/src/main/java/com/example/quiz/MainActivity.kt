package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_nombre = findViewById<EditText>(R.id.txt_nombre)
        val txt_clave = findViewById<EditText>(R.id.txt_clave)
        val btningresar = findViewById<Button>(R.id.btn_ingresar)


        btningresar.setOnClickListener {
            var nombre = txt_nombre.text.toString()
            var clave = txt_clave.text.toString()
            if (nombre == "Fabiana" && clave == "2019") {
                val f2 = Intent(this, MenuActivity::class.java)
                f2.putExtra("nombre", txt_nombre.text.toString())
                startActivity(f2)
            } else {
                Toast.makeText(
                    applicationContext,
                    "Error al ingresar el usuario o la contraseña",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}







