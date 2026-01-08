package com.example.semana1pv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.semana1pv.ui.theme.Semana1pvTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana1pvTheme {
                    Greeting(
                        name = "Android"
                    )

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier.fillMaxSize()
                .padding(16.dp)){
        Text(
            text = "HOLAAA $name!",
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
                .background(Color.Red)

        )
        titutlo()
        Row{
            subtitulo()
            subtitulo()
        }
        titutlo()
        titutlo()
        subtitulo()
        titutlo()
        subtitulo()
        titutlo()
        subtitulo()
    }
}

@Preview(showBackground = true)
@Composable
fun titutlo(){
    Text(text = "Titulo",
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp)
            .background(Color.Blue)
    )

}

@Composable
fun subtitulo(){
    Text(text = "Titulo",
        modifier = Modifier
            .padding(0.dp)
            .background(Color.Green)
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Semana1pvTheme {
        Greeting("Android")
    }
}