package com.example.semana1pv.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.semana1pv.R
import com.example.semana1pv.model.Persona
import com.example.semana1pv.service.PersonaService
import com.example.semana1pv.ui.theme.*
import com.example.semana1pv.ui.theme.*
import com.example.semana1pv.util.Validaciones

@Composable
fun RegistroScreen(
    // ** ACA NUEVO - Callback para navegar a Login
    onLoginClick: () -> Unit = {},
    onRegistroClick: () -> Unit = {}
) {

    var rut by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellidoPaterno by remember { mutableStateOf("") }
    var apellidoMaterno by remember { mutableStateOf("") }
    var region by remember { mutableStateOf("") }
    var comuna by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agree by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    var context = LocalContext.current
    val canSubmit = rut.isNotBlank() && nombre.isNotBlank() && apellidoPaterno.isNotBlank() &&
            apellidoMaterno.isNotBlank() && region.isNotBlank() && comuna.isNotBlank() &&
            telefono.isNotBlank() && email.isNotBlank() && password.isNotBlank() &&
            confirmPassword.isNotBlank() && password == confirmPassword && agree

    Surface(modifier = Modifier.fillMaxSize(), color = BackgroundLigth) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(26.dp))
            Spacer(Modifier.height(60.dp))

            Card(
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(92.dp)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        tint = Color.Unspecified
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            Text(
                text = "Crear Cuenta",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold,
                color = TextDark
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = "Regístrate para comenzar a usar la app.",
                style = MaterialTheme.typography.bodyMedium,
                color = TextMuted
            )

            Spacer(Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {

                    Text(
                        text = "Información Personal",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = TextMuted,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(14.dp))

                    OutlinedTextField(
                        value = rut,
                        onValueChange = { rut = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("RUT") },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Nombre") },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = apellidoPaterno,
                        onValueChange = { apellidoPaterno = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Apellido Paterno") },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = apellidoMaterno,
                        onValueChange = { apellidoMaterno = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Apellido Materno") },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = region,
                        onValueChange = { region = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Región") },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = comuna,
                        onValueChange = { comuna = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Comuna") },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = telefono,
                        onValueChange = { telefono = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Teléfono") },
                        leadingIcon = {
                            Icon(Icons.Default.Phone, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(16.dp))
                    Divider(color = BackgroundLigth, thickness = 1.dp)
                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = "Credenciales de Acceso",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = TextMuted,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(14.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Correo") },
                        leadingIcon = {
                            Icon(Icons.Default.Email, contentDescription = null, tint = BandGreen)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Contraseña") },
                        leadingIcon = {
                            Icon(Icons.Default.Lock, contentDescription = null, tint = BandGreen)
                        },
                        trailingIcon = {
                            IconButton(onClick = { showPassword = !showPassword }) {
                                Icon(
                                    imageVector = if (showPassword) Icons.Default.Lock else Icons.Default.Person,
                                    contentDescription = null,
                                    tint = TextMuted
                                )
                            }
                        },
                        singleLine = true,
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Confirmar Contraseña") },
                        leadingIcon = {
                            Icon(Icons.Default.Lock, contentDescription = null, tint = BandGreen)
                        },
                        trailingIcon = {
                            IconButton(onClick = { showConfirmPassword = !showConfirmPassword }) {
                                Icon(
                                    imageVector = if (showConfirmPassword) Icons.Default.Lock else Icons.Default.Person,
                                    contentDescription = null,
                                    tint = TextMuted
                                )
                            }
                        },
                        singleLine = true,
                        visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = BandGreen,
                            unfocusedBorderColor = BackgroundLigth,
                            focusedLabelColor = BandGreen,
                            cursorColor = BandGreen
                        )
                    )

                    Spacer(Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = { agree = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = BandGreen,
                                uncheckedColor = TextMuted,
                                checkmarkColor = Color.White
                            )
                        )
                        Text(
                            text = "Acepto términos y condiciones",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextMuted
                        )
                    }

                    Spacer(Modifier.height(10.dp))

                    Button(
                        onClick = {
                            val validacionCorreo = Validaciones.validarCorreo(email)
                            val validacionPassword = Validaciones.validarPassword(password)
                            val validacionRut = Validaciones.validarRut(rut)

                            val nuevaPersona = Persona(
                                rut =rut,
                                nombre = nombre,
                                apellidoPaterno = apellidoPaterno,
                                apellidoMaterno = apellidoMaterno,
                                region = region,
                                comuna = comuna,
                                telefono = telefono,
                                email = email,
                                password = password
                            )

                            PersonaService.agregarPersona(nuevaPersona)
                            Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                            Log.d("RegistroScreen", "Registro ok $nuevaPersona")
                            onRegistroClick()
                        },
                        enabled = canSubmit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = BandGreen,
                            disabledContainerColor = BandGreen.copy(alpha = 0.35f)
                        )
                    ) {
                        Text(
                            text = "Registrarse",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    // ** ACA NUEVO - Footer con navegación a Login
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onLoginClick() },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "¿Ya tienes cuenta?",
                            color = TextMuted
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = "Inicia sesión",
                            color = BrandOrange,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(Modifier.height(22.dp))
        }
    }
}
