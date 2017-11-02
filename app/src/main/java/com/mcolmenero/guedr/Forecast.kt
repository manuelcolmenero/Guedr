package com.mcolmenero.guedr

// Se crea una clase para guardar temperatura, humedad, descripción e imagen
// data class crea los setters/getters y constructores básicos
data class Forecast(val maxTemp: Float,
                    val minTemp: Float,
                    val humidity: Float,
                    val description: String,
                    val icon: Int)