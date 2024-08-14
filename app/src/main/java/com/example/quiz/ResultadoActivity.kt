package com.example.quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Context

class ResultadoActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Asignación de los IDs
        txtResultado = findViewById(R.id.txtResultado)
        btnVolver = findViewById(R.id.btnVolver)



        // Inicializar SharedPreferences
        val sharedPreferences = getSharedPreferences("quiz_results", Context.MODE_PRIVATE)


        //NOTAS DE MATERIAS
        //Obtener la nota de matemáticas de SharedPreferences
        val notaMate = sharedPreferences.getInt(MateQuizActivity1.NOTA_MATE_KEY, 0)
        // Obtener la nota de inglés de SharedPreferences
        val notaIng = sharedPreferences.getInt(InglesQuizActivity1.NOTA_INGLES_KEY, 0)
        // Obtener la nota de historia del Ecuador de SharedPreferences
        val notaHdEc = sharedPreferences.getInt(HdEcQuizActivity1.NOTA_HDEC_KEY, 0)
        // Obtener la nota de dispositivos móviles de SharedPreferences
        val notaDisMov = sharedPreferences.getInt(DisMovQuizActivity1.NOTA_DISMOV_KEY, 0)


        // Calcular el promedio
        val promedio = (notaMate + notaIng + notaHdEc + notaDisMov) / 4

        // Mostrar los resultados
        txtResultado.text = """
            Notas:
            Materia 1: $notaMate
            Materia 2: $notaIng
            Materia 4: $notaHdEc
            Materia 5: $notaDisMov
            
            Promedio: $promedio
            Estado: ${if (promedio >= 6) "Aprobado" else "Reprobado"}
        """.trimIndent()

        // Botón para volver a la actividad anterior
        btnVolver.setOnClickListener {
            finish() // Finaliza la actividad y vuelve a la anterior
        }
    }
}

