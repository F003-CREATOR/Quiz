package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.DisMovQuizActivity1
import com.example.quiz.HdEcQuizActivity1
import com.example.quiz.InglesQuizActivity1
import com.example.quiz.MateQuizActivity1
import com.example.quiz.ResultadoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val matequiz = findViewById<Button>(R.id.Btn_Mate)
        val ingquiz = findViewById<Button>(R.id.Btn_Ing)
        val hdequiz = findViewById<Button>(R.id.Btn_HdEc)
        val dispmovquiz = findViewById<Button>(R.id.Btn_DisMov)
        val resultados = findViewById<Button>(R.id.btnresultados)

        // Configurar el comportamiento de clic para cada botón
        matequiz.setOnClickListener {
            startActivity(Intent(this, MateQuizActivity1::class.java))
        }

        ingquiz.setOnClickListener {
            startActivity(Intent(this, InglesQuizActivity1::class.java))
        }

        hdequiz.setOnClickListener {
            startActivity(Intent(this, HdEcQuizActivity1::class.java))
        }

        dispmovquiz.setOnClickListener {
            startActivity(Intent(this, DisMovQuizActivity1::class.java))
        }

        resultados.setOnClickListener {
            startActivity(Intent(this, ResultadoActivity::class.java))
        }
    }
}
