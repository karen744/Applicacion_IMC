package com.example.myapplicationpeso.myappPeso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.example.myapplicationpeso.R
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlinx.coroutines.selects.select

class myappPeso1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myapp_peso1)
        val darkmode = findViewById<SwitchMaterial>(R.id.darkmode)
        val pesoEditText = findViewById<EditText>(R.id.pesotext1)
        val alturaEditText = findViewById<EditText>(R.id.alturatext2)
        val calcularButton = findViewById<Button>(R.id.buttoncalcular)



        calcularButton.setOnClickListener {
            val pesoText = pesoEditText.text.toString()
            val alturaText = alturaEditText.text.toString()
            var alturaEnMetros=0.0
            val peso = pesoText.toDoubleOrNull()
            val altura = alturaText.toDoubleOrNull()

            if (peso != null && altura != null ) {
                alturaEnMetros= altura
                val imc = calcularIMC(peso, alturaEnMetros)


                val intent = Intent(this, myappPeso2::class.java)
                intent.putExtra("EXTRA_IMC", imc)
                startActivity(intent)
            }
        }

        darkmode.setOnCheckedChangeListener { _, isSelected ->
            if (isSelected) {

                activarDarkMode()

            } else {
                desactivarDarkMode()
            }
        }
    }


    private fun calcularIMC(peso: Double, altura: Double): Double {
        return (peso / (altura * altura ))
    }
    private fun activarDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()

    }

    private fun desactivarDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()

    }
}

