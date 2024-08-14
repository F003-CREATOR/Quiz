package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val matequiz = findViewById<Button>(R.id.Btn_Mate)
        val ingquiz = findViewById<Button>(R.id.Btn_Ing)
        val hdequiz = findViewById<Button>(R.id.Btn_HdEc)
        val dispmovquiz = findViewById<Button>(R.id.Btn_DisMov)
        val resultados = findViewById<Button>(R.id.btnresultados)

        val Resultados = intent.getStringExtra("Resultados")

        // Configurar el comportamiento de clic para cada botón
        matequiz.setOnClickListener {
            val intent = Intent(this, MateQuizActivity1::class.java).apply{
                putExtra("Resultados", Resultados)

            }
            startActivity(intent)
        }


        ingquiz.setOnClickListener {
            val intent = Intent(this, InglesQuizActivity1::class.java).apply{
                putExtra("Resultados", Resultados)
            }
            startActivity(intent)
        }

        hdequiz.setOnClickListener {
            val intent = Intent(this, HdEcQuizActivity1::class.java).apply{
                putExtra("Resultados", Resultados)
            }
            startActivity(intent)
        }

        dispmovquiz.setOnClickListener {
            val intent = Intent(this, DisMovQuizActivity1::class.java).apply{
                putExtra("Resultados", Resultados)
            }
            startActivity(intent)
        }

        resultados.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java).apply{
                putExtra("Resultados", Resultados)
            }
            startActivity(intent)
        }

    }
}
