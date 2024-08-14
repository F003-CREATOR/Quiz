package com.example.quiz


import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import android.widget.Toast


class InglesQuizActivity1 : AppCompatActivity() {

    private lateinit var answer1: RadioButton
    private lateinit var answer2: RadioButton
    private lateinit var answer3: RadioButton
    private lateinit var answer4: RadioButton
    private lateinit var txtNpregunta: TextView
    private lateinit var txtPregunta: TextView
    private lateinit var btnSiguiente: Button
    private lateinit var btnSalir: Button

    companion object {
        const val NOTA_INGLES_KEY = "nota_ing" //Clave para guardar la nota en SharedPreferences
    }
    private var Npregunta = 1
    private var nota2 = 0 // Variable para almacenar la nota (mutable)
    private val correctAnswers = listOf(1, 2, 2, 2, 3, 2, 3, 2, 3, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingles_quiz1)

        // Asignación de los IDs
        answer1 = findViewById<RadioButton>(R.id.answer1)
        answer2 = findViewById<RadioButton>(R.id.answer2)
        answer3 = findViewById<RadioButton>(R.id.answer3)
        answer4 = findViewById<RadioButton>(R.id.answer4)

        txtNpregunta = findViewById(R.id.text_question1)
        txtPregunta = findViewById(R.id.text_question2)

        btnSiguiente = findViewById(R.id.btn_sig)
        btnSalir = findViewById(R.id.btn_salir)


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
            nota2 += 1
        }
    }

    private fun mostrarPregunta() {
        txtNpregunta.text = "Pregunta $Npregunta"

        when (Npregunta) {
            1 -> {
                txtPregunta.text = "What is the correct form of the verb in the following sentence?: \"She ___ to the gym every morning.\""
                answer1.text = "A) goes"
                answer2.text = "B) go"
                answer3.text = "C) going"
                answer4.text = "D) gone"
            }
            2 -> {
                txtPregunta.text = "Which of the following is a synonym of the word \"happy\"?"
                answer1.text = "A) Sad"
                answer2.text = "B) Joyful"
                answer3.text = "C) Angry"
                answer4.text = "D) Worried"
            }
            3 -> {
                txtPregunta.text = "Choose the correct preposition to complete the sentence: \"They are interested ___ learning English.\"?"
                answer1.text = "A) on"
                answer2.text = "B) in"
                answer3.text = "C) at"
                answer4.text = "D) by"
            }
            4 -> {
                txtPregunta.text = "What is the past tense of the verb \"to see\"?"
                answer1.text = "A) Seed"
                answer2.text = "B) Saw"
                answer3.text = "C) Seen"
                answer4.text = "D) Sees"
            }
            5 -> {
                txtPregunta.text = "Which sentence is grammatically correct?"
                answer1.text = "A) She don't like ice cream."
                answer2.text = "B) She doesn't likes ice cream."
                answer3.text = "C) She doesn't like ice cream."
                answer4.text = "D)  She don't likes ice cream."
            }
            6 -> {
                txtPregunta.text = "Choose the correct article for the sentence: \"___ apple a day keeps the doctor away.\""
                answer1.text = "A) A"
                answer2.text = "B) An"
                answer3.text = "C) The"
                answer4.text = "D) No article needed"
            }
            7 -> {
                txtPregunta.text = "What is the plural form of the word \"child\"?"
                answer1.text = "A) Childs"
                answer2.text = "B) Childes"
                answer3.text = "C) Children"
                answer4.text = "D) Childen"
            }
            8 -> {
                txtPregunta.text = "Which of the following sentences uses the correct comparative form?"
                answer1.text = "A) She is more tall than her brother."
                answer2.text = "B) She is taller than her brother."
                answer3.text = "C) She is the most tall than her brother."
                answer4.text = "D) She is as tall than her brother."
            }
            9 -> {
                txtPregunta.text = "Identify the correct sentence structure:"
                answer1.text = "A) The quickly dog brown jumped."
                answer2.text = "B) Quickly the brown dog jumped.\n"
                answer3.text = "C) The brown dog quickly jumped."
                answer4.text = "D) The brown quickly jumped dog."
            }
            10 -> {
                txtPregunta.text = "Which of the following is a correct question in English?"
                answer1.text = "A) You are coming to the party?"
                answer2.text = "B) Are you coming to the party?"
                answer3.text = "C) Coming you to the party?"
                answer4.text = "D) Are coming to the party you?"
            }
        }

        // Limpiar los checkboxes para la siguiente pregunta
        answer1.isChecked = false
        answer2.isChecked = false
        answer3.isChecked = false
        answer4.isChecked = false
    }

    private fun mostrarResultados() {
        // Guardar la nota en SharedPreferences
        val sharedPreferences = getSharedPreferences("quiz_results2", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(NOTA_INGLES_KEY, nota2)
        // Volver al menú principal
        editor.apply()

        // Volver al menú principal
        finish()
    }
}

