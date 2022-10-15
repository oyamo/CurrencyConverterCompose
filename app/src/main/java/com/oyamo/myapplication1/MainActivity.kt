package com.oyamo.myapplication1

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oyamo.myapplication1.ui.theme.MyApplication1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier
        .fillMaxWidth().padding(16.dp)) {

        // Declare variables
        var ksh  by remember { mutableStateOf(TextFieldValue("")) }
        var usd  by remember { mutableStateOf(0.0) }
        val RATE = 120.0

        Text(text = "Currency Converter", modifier = Modifier.fillMaxWidth(), style = MaterialTheme.typography.h5,)
        Spacer(modifier =Modifier.height(10.dp))
        Text(text = "Enter Amount in Ksh", modifier = Modifier.fillMaxWidth())

        TextField(value =  ksh,
            onValueChange ={
            ksh = it
        } ,modifier = Modifier.fillMaxWidth().height(50.dp))

        Spacer(modifier =Modifier.height(10.dp))

        Text(text = "Amount in USD: $usd", modifier = Modifier.fillMaxWidth())

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                usd = ksh.text.toDouble() / RATE
        }) {
            Text(text ="Convert")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyApplication1Theme {
        Greeting("Android")
    }
}