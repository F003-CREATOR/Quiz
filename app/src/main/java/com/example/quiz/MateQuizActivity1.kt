package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import android.content.Context


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
        const val NOTA_MATE_KEY = "nota_mate" //Clave para guardar la nota en SharedPreferences
    }

    private var Npregunta = 1
    private var nota1 = 0 // Variable para almacenar la nota (mutable)
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
                txtPregunta.text =
                    "Si un triángulo tiene dos ángulos de 45°, ¿cuál es el valor del tercer ángulo?"
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
                txtPregunta.text = "¿Cuál es el área de un cuadrado de lado 5 cm?"
                answer1.text = "A) 15 cm²"
                answer2.text = "B) 20 cm²"
                answer3.text = "C) 25 cm²"
                answer4.text = "D) 30 cm²"
            }

            6 -> {
                txtPregunta.text = "¿Cuánto es 10 ÷ 2 + 4?"
                answer1.text = "A) 5"
                answer2.text = "B) 9"
                answer3.text = "C) 7"
                answer4.text = "D) 8"
            }

            7 -> {
                txtPregunta.text = "¿Cuánto es (3 + 5) × 2?"
                answer1.text = "A) 10"
                answer2.text = "B) 13"
                answer3.text = "C) 16"
                answer4.text = "D) 18"
            }

            8 -> {
                txtPregunta.text = "¿Cuál es la raíz cuadrada de 49?"
                answer1.text = "A) 9"
                answer2.text = "B) 6"
                answer3.text = "C) 7"
                answer4.text = "D) 8"
            }

            9 -> {
                txtPregunta.text = "Si 2x = 10, ¿cuál es el valor de x?"
                answer1.text = "A) 5"
                answer2.text = "B) 10"
                answer3.text = "C) 15"
                answer4.text = "D) 20"
            }

            10 -> {
                txtPregunta.text = "¿Cuánto es 9 + 10?"
                answer1.text = "A) 18"
                answer2.text = "B) 20"
                answer3.text = "C) 19"
                answer4.text = "D) 21"
            }
        }

        // Desmarcar las opciones para la nueva pregunta
        answer1.isChecked = false
        answer2.isChecked = false
        answer3.isChecked = false
        answer4.isChecked = false
    }


    private fun mostrarResultados() {
        // Guardar la nota en SharedPreferences
        val sharedPreferences = getSharedPreferences("quiz_results", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(NOTA_MATE_KEY, nota1)
        // Volver al menú principal
        editor.apply()


        // Volver al menú principal
        finish()
    }
}







