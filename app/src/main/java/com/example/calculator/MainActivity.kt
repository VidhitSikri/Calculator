package com.example.calculator

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator()
        }
    }
}



@Composable
fun Calculator() {

    var inputString = remember {
        mutableStateOf("")
    }
    var result = remember {
        mutableStateOf(0.0)
    }
    fun evalutation(){
        var inputArray = inputString.value.split(" ")
        var finalAns = inputArray[0].toDouble()
        var operator:String = ""
        for(num in 1..inputArray.size-1) {
            if(inputArray[num] == "+" || inputArray[num] == "-" ||
                inputArray[num] == "X" || inputArray[num] == "/" || inputArray[num] == "%") {
                operator = inputArray[num]
            }
            else {
                if(operator == "+") {
                    finalAns = finalAns + inputArray[num].toDouble()
                }
                if(operator == "-") {
                    finalAns = finalAns - inputArray[num].toDouble()
                }
                if(operator == "X") {
                    finalAns = finalAns * inputArray[num].toDouble()
                }
                if(operator == "/") {
                    finalAns = finalAns / inputArray[num].toDouble()
                }

            }
        }
        result.value = finalAns
    }

    fun eraser() {
        if(inputString.value.last() == ' ') {
            inputString.value = inputString.value.dropLast(3)
        }
        else {
            inputString.value = inputString.value.dropLast(1)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .border(5.dp, color = Color.Gray)
        ) {
            
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                
                Text(text = "${inputString.value}",color = Color.White, fontSize = 30.sp,
                    modifier = Modifier.padding(20.dp))
                
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                
                Text(text = "${result.value}",color = Color.White, fontSize = 60.sp,
                    modifier = Modifier.padding(20.dp))
            }
            
        }
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .border(5.dp, color = Color.Gray)
        ) {

            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {
                    inputString.value = "";
                    result.value = 0.0
                                 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                    ) {
                    Text(text = "AC", fontSize = 30.sp)
                }
                Button(onClick = {
                    inputString.value = inputString.value + " % "
                                 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "%", fontSize = 30.sp)
                }
                Button(onClick = {
                                 eraser()
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "E", fontSize = 30.sp)
                }
                Button(onClick = {
                          inputString.value = inputString.value + " / "
                                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "/", fontSize = 30.sp)
                }

            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {inputString.value = inputString.value + "7"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "7", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "8"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "8", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "9"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "9", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + " X "},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "X", fontSize = 30.sp)
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {inputString.value = inputString.value + "4"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "4", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "5"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "5", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "6"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "6", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + " - "},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "-", fontSize = 30.sp)
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {inputString.value = inputString.value + "1"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "1", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "2"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "2", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "3"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "3", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + " + "},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "+", fontSize = 30.sp)
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {inputString.value = inputString.value + "00"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "00", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "0"},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "0", fontSize = 30.sp)
                }
                Button(onClick = {inputString.value = inputString.value + "."},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = ".", fontSize = 30.sp)
                }
                Button(onClick = {
                                 evalutation();
                    inputString.value = result.value.toString()
                                 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                ) {
                    Text(text = "=", fontSize = 30.sp)
                }
            }
        }
    }
}