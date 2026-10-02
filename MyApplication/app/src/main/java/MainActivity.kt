package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color


@Preview
@Composable
fun Teste(){
    Restaurante()
}

@Composable
fun Restaurante(){
    var contador by remember { mutableIntStateOf(1) }
    val KotlinPurple = Color(0xFFB125EA)
    var valor = contador * 24.90
    // COLUMN: organiza os elementos na vertical, centralizados
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SABOR DO SERTÃO",
            modifier = Modifier.padding(50.dp)

        )

        Text(text = "Comida regional")
        Spacer(modifier = Modifier.height(24.dp))

        Text(text="Avaliação: 3.2")
        Text(text="Tempo: 1 hora")
        Spacer(modifier = Modifier.height(24.dp))


        Text(text="Prato do dia: Cuscuz")
        Text(text = "R$ %.2f".format(valor))
        Spacer(modifier = Modifier.height(24.dp))

        // ROW: coloca os botões e o texto lado a lado na horizontal
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

                Button(onClick = {
                    if (contador > 1) {
                        contador--
                        valor -= 24.90
                    }
                }) {
                    Text(text = "[ - ]")
                }

                Text(text = "Quantidade ($contador)")

                Button(onClick = { contador++ }) {
                    Text(text = "[ + ]")
                }

            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {KotlinPurple}) {
                Text(text = "[Fazer pedido]")
         }

    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Restaurante()
        }
    }
}