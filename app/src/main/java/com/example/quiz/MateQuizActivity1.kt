package com.example.quiz

import ResultadoActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MateQuizActivity1 : AppCompatActivity() {

    private lateinit var answer1: CheckBox
    private lateinit var answer2: CheckBox
    private lateinit var answer3: CheckBox
    private lateinit var answer4: CheckBox
    private lateinit var txtNpregunta: TextView
    private lateinit var txtPregunta: TextView
    private lateinit var btnSiguiente: Button
    private lateinit var btnSalir: Button

    companion object {
        private var nota1 = 0
    }
    private var Npregunta = 1

    private val correctAnswers = listOf(4, 3, 1, 2, 3, 2, 3, 3, 1, 3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mate_quiz1)

        // Asignación de los IDs
        answer1 = findViewById(R.id.btn1)
        answer2 = findViewById(R.id.btn2)
        answer3 = findViewById(R.id.btn3)
        answer4 = findViewById(R.id.btn4)

        txtNpregunta = findViewById(R.id.txtNpregunta)
        txtPregunta = findViewById(R.id.txtPregunta)

        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnSalir = findViewById(R.id.btnSalir)

        btnSiguiente.setOnClickListener {
            siguiente(it)
        }

        btnSalir.setOnClickListener {
            finish() // Finaliza la actividad
        }

        // Mostrar la primera pregunta
        mostrarPregunta()
    }

    private fun siguiente(v: View) {
        if (!answer1.isChecked && !answer2.isChecked && !answer3.isChecked && !answer4.isChecked) {
            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show()
        } else {
            verificarRespuesta()

            if (Npregunta < 10) {
                Npregunta++
                mostrarPregunta()
            } else {
                mostrarResultados()
            }
        }
    }

    private fun verificarRespuesta() {
        val selectedAnswer = when {
            answer1.isChecked -> 1
            answer2.isChecked -> 2
            answer3.isChecked -> 3
            answer4.isChecked -> 4
            else -> 0
        }

        if (selectedAnswer == correctAnswers[Npregunta - 1]) {
            nota1 += 1
        }
    }

    private fun mostrarPregunta() {
        txtNpregunta.text = "Pregunta $Npregunta"

        when (Npregunta) {
            1 -> {
                txtPregunta.text = "¿Cuánto es 5 + 3?"
                answer1.text = "A) 6"
                answer2.text = "B) 7"
                answer3.text = "C) 8"
                answer4.text = "D) 9"
            }
            2 -> {
                txtPregunta.text = "¿Cuál es el resultado de 12 + 8 × 2?"
                answer1.text = "A) 40"
                answer2.text = "B) 32"
                answer3.text = "C) 28"
                answer4.text = "D) 24"
            }
            3 -> {
                txtPregunta.text = "Si un triángulo tiene dos ángulos de 45°, ¿cuál es el valor del tercer ángulo?"
                answer1.text = "A) 90°"
                answer2.text = "B) 60°"
                answer3.text = "C) 45°"
                answer4.text = "D) 135°"
            }
            4 -> {
                txtPregunta.text = "Si 3x + 2 = 14, ¿cuál es el valor de x?"
                answer1.text = "A) 4"
                answer2.text = "B) 6"
                answer3.text = "C) 5"
                answer4.text = "D) 3"
            }
            5 -> {
                txtPregunta.text = "¿Cuál es el valor de 7×8?"
                answer1.text = "A) 54"
                answer2.text = "B) 56"
                answer3.text = "C) 58"
                answer4.text = "D) 60"
            }
            6 -> {
                txtPregunta.text = "¿Cuál es la raíz cuadrada de 144?"
                answer1.text = "A) 10"
                answer2.text = "B) 11"
                answer3.text = "C) 12"
                answer4.text = "D) 13"
            }
            7 -> {
                txtPregunta.text = "¿Cuál es el resultado de 9^2?"
                answer1.text = "A) 72"
                answer2.text = "B) 81"
                answer3.text = "C) 90"
                answer4.text = "D) 99"
            }
            8 -> {
                txtPregunta.text = "Si x = 5, ¿cuál es el valor de 2x + 3?"
                answer1.text = "A) 10"
                answer2.text = "B) 12"
                answer3.text = "C) 13"
                answer4.text = "D) 15"
            }
            9 -> {
                txtPregunta.text = "¿Cuál es el resultado de 15 ÷ 3?"
                answer1.text = "A) 3"
                answer2.text = "B) 4"
                answer3.text = "C) 5"
                answer4.text = "D) 6"
            }
            10 -> {
                txtPregunta.text = "¿Cuál es la suma de los ángulos interiores de un triángulo?"
                answer1.text = "A) 180°"
                answer2.text = "B) 90°"
                answer3.text = "C) 360°"
                answer4.text = "D) 270°"
            }
        }

        // Limpiar los checkboxes para la siguiente pregunta
        answer1.isChecked = false
        answer2.isChecked = false
        answer3.isChecked = false
        answer4.isChecked = false
    }


    private fun mostrarResultados() {
        txtNpregunta.text = "Nota obtenida: $nota1"
        txtPregunta.text = if (nota1 >= 6) {
            "Estado: Aprobado"


        } else {
            "Estado: Reprobado"
        }

        //Envia a ResultadoActivity//
        var intent = Intent (this, ResultadoActivity::class.java)
        intent.putExtra("nota1",nota1)
        startActivity(intent)

        // Ocultar los elementos no necesarios
        answer1.visibility = View.GONE
        answer2.visibility = View.GONE
        answer3.visibility = View.GONE
        answer4.visibility = View.GONE
        btnSiguiente.visibility = View.GONE
    }
}
