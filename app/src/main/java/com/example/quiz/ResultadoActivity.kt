package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class ResultadoActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Asignación de los IDs
        txtResultado = findViewById(R.id.txtResultado)
        btnVolver = findViewById(R.id.btnVolver)

        // Obtener las notas de las materias desde el Intent
        val nota1 = intent.getIntExtra("nota1", 0)
        val nota2 = intent.getIntExtra("nota2", 0)
        val nota4 = intent.getIntExtra("nota4", 0)
        val nota5 = intent.getIntExtra("nota5", 0)

        // Calcular el promedio
        val promedio = (nota1 + nota2 + nota4 + nota5) / 4

        // Mostrar los resultados
        txtResultado.text = """
            Notas:
            Materia 1: $nota1
            Materia 2: $nota2
            Materia 4: $nota4
            Materia 5: $nota5
            
            Promedio: $promedio
            Estado: ${if (promedio >= 6) "Aprobado" else "Reprobado"}
        """.trimIndent()

        // Botón para volver a la actividad anterior
        btnVolver.setOnClickListener {
            finish() // Finaliza la actividad y vuelve a la anterior
        }
    }
}

