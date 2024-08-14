import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.quiz.R

class DisMovQuizActivity1 : AppCompatActivity() {

    private lateinit var answer1: CheckBox
    private lateinit var answer2: CheckBox
    private lateinit var answer3: CheckBox
    private lateinit var answer4: CheckBox
    private lateinit var txtNpregunta: TextView
    private lateinit var txtPregunta: TextView
    private lateinit var btnSiguiente: Button
    private lateinit var btnSalir: Button

    companion object {
        private var nota5 = 0
    }
    private var Npregunta = 1

    private val correctAnswers = listOf(3, 1, 4, 2, 3, 2, 3, 2, 2, 4)

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
            nota5 += 1
        }
    }

    private fun mostrarPregunta() {
        txtNpregunta.text = "Pregunta $Npregunta"

        when (Npregunta) {
            1 -> {
                txtPregunta.text = "¿Cuál es el sistema operativo más utilizado en dispositivos móviles?"
                answer1.text = "A) iOS"
                answer2.text = "B) Windows Mobile"
                answer3.text = "C) Android"
                answer4.text = "D) BlackBerry OS"
            }
            2 -> {
                txtPregunta.text = "¿Qué significa \"RAM\" en el contexto de un dispositivo móvil?"
                answer1.text = "A) Random Access Memory"
                answer2.text = "B) Readable Access Module"
                answer3.text = "C) Real Application Memory"
                answer4.text = "D) Remote Access Memory"
            }
            3 -> {
                txtPregunta.text = "¿Cuál de los siguientes es un componente clave en la duración de la batería de un dispositivo móvil?"
                answer1.text = "A) El tamaño de la pantalla"
                answer2.text = "B) La resolución de la cámara"
                answer3.text = "C) La capacidad de almacenamiento"
                answer4.text = "D) El procesador"
            }
            4 -> {
                txtPregunta.text = "¿Qué tecnología permite realizar pagos con un dispositivo móvil al acercarlo a un terminal de pago?"
                answer1.text = "A) Wi-Fi"
                answer2.text = "B) NFC (Near Field Communication)"
                answer3.text = "C) Bluetooth"
                answer4.text = "D) LTE"
            }
            5 -> {
                txtPregunta.text = "¿Qué función realiza un sensor de proximidad en un teléfono móvil?"
                answer1.text = "A) Detectar la orientación del dispositivo."
                answer2.text = "B) Ajustar el brillo de la pantalla."
                answer3.text = "C) Apagar la pantalla durante una llamada."
                answer4.text = "D) Medir la frecuencia cardíaca."
            }
            6 -> {
                txtPregunta.text = "¿Cuál es el propósito de un \"modo avión\" en un dispositivo móvil?"
                answer1.text = "A)  Aumentar la velocidad de procesamiento"
                answer2.text = "B) Desactivar todas las conexiones inalámbricas"
                answer3.text = "C) Mejorar la calidad de la cámara"
                answer4.text = "D) Hacer que el dispositivo sea resistente al agua"
            }
            7 -> {
                txtPregunta.text = "¿Qué tipo de pantalla es más común en los dispositivos móviles modernos?"
                answer1.text = "A) LCD"
                answer2.text = "B) LED"
                answer3.text = "C) OLED"
                answer4.text = "D) Plasma"
            }
            8 -> {
                txtPregunta.text = "¿Qué es un \"procesador de ocho núcleos\"?"
                answer1.text = "A) Un procesador con ocho núcleos gráficos"
                answer2.text = "B) Un procesador con ocho núcleos de CPU"
                answer3.text = "C) Un procesador con ocho GB de RAM"
                answer4.text = "D) Un procesador con ocho cámaras"
            }
            9 -> {
                txtPregunta.text = "¿Qué aplicación se utiliza comúnmente para la navegación GPS en dispositivos móviles?"
                answer1.text = "A) WhatsApp"
                answer2.text = "B) Google Maps"
                answer3.text = "C) Instagram"
                answer4.text = "D) Spotify"
            }
            10 -> {
                txtPregunta.text = "¿Qué tipo de almacenamiento interno es más rápido en dispositivos móviles?"
                answer1.text = "A) HDD"
                answer2.text = "B) eMMC"
                answer3.text = "C) SD"
                answer4.text = "D) UFS (Universal Flash Storage)"
            }
        }

        // Limpiar los checkboxes para la siguiente pregunta
        answer1.isChecked = false
        answer2.isChecked = false
        answer3.isChecked = false
        answer4.isChecked = false
    }

    private fun mostrarResultados() {
        txtNpregunta.text = "Nota obtenida: $nota5"
        txtPregunta.text = if (nota5 >= 6) {
            "Estado: Aprobado"
        } else {
            "Estado: Reprobado"
        }

        var intent = Intent (this, ResultadoActivity::class.java)
        intent.putExtra("nota5", nota5)
        startActivity(intent)

        // Ocultar los elementos no necesarios
        answer1.visibility = View.GONE
        answer2.visibility = View.GONE
        answer3.visibility = View.GONE
        answer4.visibility = View.GONE
        btnSiguiente.visibility = View.GONE
    }
}
