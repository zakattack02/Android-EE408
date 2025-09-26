package com.example.unitconverterapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.SpanStyle


//Placing the result below the input field and conversion buttons is the better option it follows the natural
//top-to-bottom reading flow: users enter a value, choose a conversion, and then see the result afterward.
//This makes the interface more intuitive, since the output always appears at the end of
//the interaction rather than interrupting the input area.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    var selectedConversion by remember { mutableStateOf("mph → kph") }

    val conversions = listOf(
        "mph → kph",
        "kph → mph",
        "kg → lbs",
        "lbs → kg",
        "°C → °F",
        "°F → °C"
    )

    val (result, error) = remember(input, selectedConversion) {
        try {
            val value = input.toDouble()
            fun Double.format(digits: Int) = "%.${digits}f".format(this)
            val res = when (selectedConversion) {
//                "mph → kph" -> "${value * 1.61} kph"
//                "kph → mph" -> "${value * 0.621} mph"
//                "kg → lbs" -> "${value * 2.2} lbs"
//                "lbs → kg" -> "${value * 0.454} kg"
//                "°C → °F" -> "${(value * 1.8) + 32} °F"
//                "°F → °C" -> "${(value - 32) * 5 / 9} °C"
                "mph → kph" -> "${(value * 1.61).format(2)} kph"
                "kph → mph" -> "${(value * 0.621).format(2)} mph"
                "kg → lbs" -> "${(value * 2.2).format(2)} lbs"
                "lbs → kg" -> "${(value * 0.454).format(2)} kg"
                "°C → °F" -> "${((value * 1.8) + 32).format(2)} °F"
                "°F → °C" -> "${((value - 32) * 5 / 9).format(2)} °C"
                else -> ""
            }
            res to ""
        } catch (e: NumberFormatException) { "" to "Please enter a valid number"
        }
    }

    // Background gradient
    val gradientColors = listOf(Color(0xFF60A5FA), Color(0xFF22D3EE))

    Column(
        modifier = modifier
            .background(Brush.verticalGradient(gradientColors))
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Enter a value") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF93C5FD),
                unfocusedContainerColor = Color(0xFF93C5FD),
                focusedIndicatorColor = Color(0xFF3B82F6),
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        //Buttons grouped by category
        CategorySection("Speed", listOf("mph → kph", "kph → mph"), selectedConversion) {
            selectedConversion = it
        }

        CategorySection("Mass", listOf("kg → lbs", "lbs → kg"), selectedConversion) {
            selectedConversion = it
        }

        CategorySection("Temperature", listOf("°C → °F", "°F → °C"), selectedConversion) {
            selectedConversion = it
        }

        if (error.isNotEmpty()) {
            Text(text = error, color = Color.Red)
        }

        Text(
            text = "Result: $result",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun CategorySection(
    title: String,
    options: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = Color.Black)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            options.forEach { option ->
                val isSelected = option == selected

                Button(
                    onClick = { onSelect(option) },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = if (isSelected) Color.White else Color.Black
                    ),
                    contentPadding = PaddingValues(0.dp) //Box sets the size
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                if (isSelected) {
                                    Brush.horizontalGradient(
                                        listOf(Color(0xFFA855F7), Color(0xFFEC4899))
                                    )
                                } else {
                                    Brush.horizontalGradient(
                                        listOf(Color.LightGray, Color.LightGray)
                                    )
                                },
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(vertical = 8.dp),
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        Text(option)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterAppTheme {
        UnitConverter()
    }
}
