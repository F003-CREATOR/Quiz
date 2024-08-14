package com.example.quiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast


class HdEcQuizActivity1 : AppCompatActivity() {

    private lateinit var answer1: CheckBox
    private lateinit var answer2: CheckBox
    private lateinit var answer3: CheckBox
    private lateinit var answer4: CheckBox
    private lateinit var txtNpregunta: TextView
    private lateinit var txtPregunta: TextView
    private lateinit var btnSiguiente: Button
    private lateinit var btnSalir: Button

    companion object {
        const val NOTA_HDEC_KEY = "nota_hdec" //Clave para guardar la nota en SharedPreferences
    }
    private var Npregunta = 1
    private var nota4 = 0 // Variable para almacenar la nota (mutable)
    private val correctAnswers = listOf(2, 3, 2, 3, 1, 4, 2, 2, 4, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hd_ec_quiz1)

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
            nota4 += 1
        }
    }

    private fun mostrarPregunta() {
        txtNpregunta.text = "Pregunta $Npregunta"

        when (Npregunta) {
            1 -> {
                txtPregunta.text = "¿En qué año se declaró la independencia de Quito, considerada como el primer grito de independencia en América Latina?"
                answer1.text = "A) 1820"
                answer2.text = "B) 1809"
                answer3.text = "C) 1810"
                answer4.text = "D) 1830"
            }
            2 -> {
                txtPregunta.text = "¿Cuál fue el primer presidente del Ecuador?"
                answer1.text = "A) Vicente Rocafuerte"
                answer2.text = "B) Gabriel García Moreno"
                answer3.text = "C) Juan José Flores"
                answer4.text = "D) Eloy Alfaro"
            }
            3 -> {
                txtPregunta.text = "¿Qué tratado definió los límites entre Ecuador y Perú en 1942?"
                answer1.text = "A) Tratado de Tordesillas"
                answer2.text = "B) Tratado de Río de Janeiro"
                answer3.text = "C) Tratado de Guayaquil"
                answer4.text = "D) Tratado de Paz y Amistad"
            }
            4 -> {
                txtPregunta.text = "¿Qué líder indígena encabezó la Gran Rebelión en 1780 contra las autoridades coloniales españolas?"
                answer1.text = "A) Atahualpa"
                answer2.text = "B) Rumiñahui"
                answer3.text = "C) Túpac Amaru II"
                answer4.text = "D) José de Antepara"
            }
            5 -> {
                txtPregunta.text = "¿En qué batalla se consolidó la independencia del territorio ecuatoriano?"
                answer1.text = "A) Batalla de Pichincha."
                answer2.text = "B) Batalla de Junín."
                answer3.text = "C) Batalla de Carabobo."
                answer4.text = "D) Batalla de Boyacá."
            }
            6 -> {
                txtPregunta.text = "¿Qué presidente ecuatoriano fue conocido como \"El Viejo Luchador\" por sus reformas liberales?"
                answer1.text = "A) Gabriel García Moreno"
                answer2.text = "B) Vicente Rocafuerte"
                answer3.text = "C) José María Urbina"
                answer4.text = "D) Eloy Alfaro"
            }
            7 -> {
                txtPregunta.text = "¿Qué ciudad fue capital del Reino de Quito antes de la llegada de los españoles?"
                answer1.text = "A) Cuenca"
                answer2.text = "B) Quito"
                answer3.text = "C) Guayaquil"
                answer4.text = "D) Riobamba"
            }
            8 -> {
                txtPregunta.text = "¿Cuál de los siguientes países no formaba parte de la Gran Colombia junto con Ecuador?"
                answer1.text = "A) Venezuela."
                answer2.text = "B) Peru."
                answer3.text = "C) Colombia."
                answer4.text = "D) Panamá."
            }
            9 -> {
                txtPregunta.text = "¿Qué volcán erupcionó en 1999, causando una crisis económica en Ecuador?"
                answer1.text = "A) Cotopaxi."
                answer2.text = "B) Chimborazo."
                answer3.text = "C) Reventador."
                answer4.text = "D) Pichincha."
            }
            10 -> {
                txtPregunta.text = "¿Qué acontecimiento marcó el fin de la Guerra de los Cuatro Días en 1932?"
                answer1.text = "A) La renuncia de Eloy Alfaro."
                answer2.text = "B) La firma de un tratado con Perú."
                answer3.text = "C) La llegada al poder de José María Velasco Ibarra."
                answer4.text = "D) La caída del gobierno de Neptalí Bonifaz."
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
        val sharedPreferences = getSharedPreferences("quiz_results4", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(NOTA_HDEC_KEY, nota4)
        // Volver al menú principal
        editor.apply()


        // Volver al menú principal
        finish()
    }
}
