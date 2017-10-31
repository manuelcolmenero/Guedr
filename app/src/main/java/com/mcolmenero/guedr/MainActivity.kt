package com.mcolmenero.guedr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Atributos de clase
//    var stoneButton:  Button? = null
//    var donkeyButton: Button? = null

    val TAG = MainActivity::class.java.canonicalName
    var offlineWeatherImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // Se referencian los botones
//        stoneButton  = findViewById<Button>(R.id.stone_button)
//        donkeyButton = findViewById<Button>(R.id.donkey_button)
//
//        // Se implementa el método onClick a cada botón
//        stoneButton?.setOnClickListener(this)
//        donkeyButton?.setOnClickListener(this)
//

        findViewById<Button>(R.id.stone_button)?.setOnClickListener(this)
        findViewById<Button>(R.id.donkey_button)?.setOnClickListener(this)

        offlineWeatherImage = findViewById<ImageView>(R.id.offline_weather_image)

        Log.v(TAG, "He pasado por onCreate")

        if (savedInstanceState != null) {
            Log.v(TAG, "savedInstanceState no es null y clave vale: ${savedInstanceState.getString("clave")}")
        } else {
            Log.v(TAG, "savedInstanceState = null")
        }
    }

    override fun onClick(v: View?) {
        Log.v(TAG,"Hemos pasado por onClick")

//        if (v == stoneButton) {
//            Log.v(TAG, "Han pulsado el botón piedra")
//        } else {
//            Log.v(TAG, "Han pulsado el botón burro")
//        }

//        if (v != null) {
//            if (v.id == R.id.stone_button) {
//                Log.v(TAG, "Han pulsado el botón piedra")
//            } else if (v.id == R.id.donkey_button) {
//                Log.v(TAG, "Han pulsado el botón burro")
//            }
//        }

//        when (v?.id) {
//            R.id.stone_button  -> Log.v(TAG, "Han pulsado el botón piedra")
//            R.id.donkey_button -> Log.v(TAG, "Han pulsado el botón burro")
//        }

        Log.v(TAG, when (v?.id) {
            R.id.stone_button -> "Han pulsado el botón piedra"
            R.id.donkey_button -> "Han pulsado el botón burro"
            else -> "No sé que se ha pulsado"
        })

//        when (v?.id) {
//            R.id.stone_button -> offlineWeatherImage?.setImageResource(R.drawable.offline_weather)
//            R.id.donkey_button -> offlineWeatherImage?.setImageResource(R.drawable.offline_weather2)
//        }

        offlineWeatherImage?.setImageResource(when (v?.id) {
            R.id.donkey_button -> R.drawable.offline_weather2
            else -> R.drawable.offline_weather
        })


    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.v(TAG, "He pasado por onSaveInstanceState")

//        if (outState != null){
//            // Aquí se puede llamar a métodos de outState
//            outState.putString("Clave","Valor")
//        }
        outState?.putString("clave","valor")
    }
}
