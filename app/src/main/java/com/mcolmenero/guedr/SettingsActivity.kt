package com.mcolmenero.guedr

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioGroup

class SettingsActivity : AppCompatActivity() {


    companion object {
        val EXTRA_UNITS = "EXTRA_UNITS"

//        fun intent(context: Context): Intent {
//            return Intent(context, SettingsActivity::class.java)
//        }

        fun intent(context: Context) = Intent(context, SettingsActivity::class.java)
    }

    var radioGroup : RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        // Se genera una clases anónimas para las pulsaciones del botón
//        findViewById<View>(R.id.ok_button).setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                //Aquí va el código de aceptar
//                acceptSettings()
//
//
//            }
//        })

        // Esto es una closure indicando que recibe V y no devuelve nada
//        findViewById<View>(R.id.ok_button).setOnClickListener { v ->
//            acceptSettings()
//        }

        findViewById<View>(R.id.ok_button).setOnClickListener { acceptSettings() }
        findViewById<View>(R.id.cancel_button).setOnClickListener { cancelSettings() }

        radioGroup = findViewById(R.id.units_rg)
    }

    private fun cancelSettings() {
        setResult(Activity.RESULT_CANCELED)
        // Se finaliza la actividad volvinedo a la anterior
        finish()
    }

    private fun acceptSettings() {
        val returnIntent = Intent()
        returnIntent.putExtra(EXTRA_UNITS, radioGroup?.checkedRadioButtonId)
        setResult(Activity.RESULT_OK, returnIntent)
        // Se finaliza la actividad volvinedo a la anterior
        finish()
    }
}