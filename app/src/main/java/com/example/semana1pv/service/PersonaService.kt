package com.example.semana1pv.service

import com.example.semana1pv.model.Persona

object PersonaService {

    private val personas = mutableListOf<Persona>()

    private var usuarioLogueado: Persona? = null

    fun agregarPersona(persona: Persona){
        personas.add(persona)
    }

    fun obtenerPersonas(): List<Persona>{
        return personas.toList()
    }

    fun obtenerPersonaPorRut(rut: String): Persona?{
        return personas.find { it.rut == rut }
    }

    fun iniciarSesion(email: String, password: String): Persona?{
        val persona = personas.find { it.email == email && it.password == password }
        usuarioLogueado = persona
        return persona
    }

    fun obtenerUsuarioActual(): Persona?{
        return usuarioLogueado

    }



}