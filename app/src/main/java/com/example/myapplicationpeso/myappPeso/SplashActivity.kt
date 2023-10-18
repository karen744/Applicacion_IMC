package com.example.myapplicationpeso.myappPeso
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationpeso.R

class SplashActivity : AppCompatActivity() {

    private val splashDuration = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Configura un temporizador para cerrar el Splash Screen después de la duración especificada
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, myappPeso1::class.java)
            startActivity(intent)
            finish()
        }, splashDuration)
    }
}