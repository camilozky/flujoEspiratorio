package co.edu.iush.respiratorioflujo

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val arrayGenero = arrayOf("Masculino", "Femenino")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayAdapterGenero =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, arrayGenero)
        arrayAdapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGenero.adapter = arrayAdapterGenero
        buttonCategorizar.setOnClickListener {
            val altura = editTextAltura.text.toString().toDouble()
            val edad = editTextEdad.text.toString().toInt()
            val valor = editTextValor.text.toString().toInt()
            val genero = spinnerGenero.selectedItem
            val categoria = categorizar(edad, genero, altura, valor)
            Snackbar.make(constraintLayout, categoria, Snackbar.LENGTH_LONG).show()
        }
    }

    fun categorizar(edad: Int, genero: Any, altura: Double, valor: Int): String {
        return if (edad > 25 && genero == "Masculino" && altura > 1.75 && valor > 100 && valor < 400) "Zona Verde"
        else if (edad <= 25 && genero == "Masculino" && altura > 1.0 && altura <= 1.75) "Zona Azul"
        else "Zona Roja"
    }
}
