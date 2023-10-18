package com.example.myapplicationpeso.myappPeso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplicationpeso.R


class myappPeso2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myapp_peso2)

        val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)


        val imc = intent.getDoubleExtra("EXTRA_IMC",0.0)


        val categoria = obtenerCategoriaIMC(imc)
        val resultadoTexto = "Tu IMC es: $imc\nCategoría: $categoria"
        resultadoTextView.text = resultadoTexto
    }

    private fun obtenerCategoriaIMC(imc: Double): String {
        return when {
            imc < 16.0 -> "Infrapeso: Delgadez severa"
            imc < 16.9 -> "Infrapeso: Delgadez moderada"
            imc < 18.4 -> "Infrapeso: Delgadez aceptable"
            imc < 24.9 -> "Peso normal"
            imc < 29.9 -> "Sobrepeso"
            imc < 34.9 -> "Obesidad: Grado I"
            imc < 39.9 -> "Obesidad: Grado II"
            else -> "Obesidad: Grado III (Obesidad mórbida)"
        }
    }
}