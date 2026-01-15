package com.example.semana1pv.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.semana1pv.ui.theme.BackgroundLigth
import com.example.semana1pv.R
import com.example.semana1pv.ui.theme.BandGreen
import com.example.semana1pv.ui.theme.BordernSoft
import com.example.semana1pv.ui.theme.TextDark
import com.example.semana1pv.ui.theme.TextMuted

@Preview(showBackground = true)
@Composable
fun LoginScreen(
    onRegistroClick: () -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize(),
        color = BackgroundLigth
         ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Card(
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)

            ) {
                Box(
                    modifier = Modifier
                        .size(220.dp)
                        .padding(18.dp),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(200.dp),
                        tint = Color.Unspecified,

                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Bienvenido/a",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold,
                color = TextDark
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Inicia sesión para continuar usando la app",
                style = MaterialTheme.typography.bodyMedium,
                color = TextMuted
            )

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)

            ){
                Column(modifier = Modifier.padding(18.dp)) { }

                Text(
                    text = "Entrar vía Redes Sociales",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextMuted,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    SocialCircle(
                        label = "F",
                        accent = BandGreen,
                    )
                    Spacer(modifier = Modifier.width(12.dp))

                    SocialCircle(
                        label = "X",
                        accent = BandGreen,
                    )
                    Spacer(modifier = Modifier.width(12.dp))

                    SocialCircle(
                        label = "I",
                        accent = BandGreen,
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                Divider(color = BordernSoft, thickness = 1.dp)
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "o inicia con Email",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextMuted,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth().padding(end = 12.dp, start = 12.dp),

                    label = { Text(text = "Correo Electronico") },

                    leadingIcon = {
                        Icon(Icons.Default.Email, contentDescription = null, tint = BandGreen)
                                  },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = BandGreen,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = BandGreen,
                        cursorColor = BandGreen,
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth().padding(end = 12.dp, start = 12.dp),

                    label = { Text(text = "Password") },

                    leadingIcon = {
                        Icon(Icons.Default.Lock, contentDescription = null, tint = BandGreen)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = BandGreen,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = BandGreen,
                        cursorColor = BandGreen,
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = onRegistroClick,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(56.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2CBE32),
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 2.dp,
                        pressedElevation = 4.dp,
                        disabledElevation = 0.dp
                    )


                ) {
                    Text(
                        text = "Iniciar",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
        }




    }


}

@Composable
private fun SocialCircle(
    label: String,
    accent: Color,
){
    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(Color.White)
            .border(1.dp, accent.copy(alpha = 0.35f), CircleShape),
        contentAlignment = Alignment.Center,
        ){
        Text(
            text = label,
            color = accent,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleMedium
        )
    }




}