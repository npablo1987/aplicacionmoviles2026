package com.example.semana1pv.util

class Validaciones {

    fun validarCorreo(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }

    fun validarPassword(password: String): Boolean {
        return password.length >= 8
    }

    fun validarRut(rut: String): Boolean {
        return rut.length >= 8
    }
}