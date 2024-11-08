package com.tama.practicecomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tama.practicecomposebasics.ui.theme.PracticeComposeBasicsTheme

class ComposeQuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeComposeBasicsTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantCardsContainer(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun QuadrantCardsContainer(modifier: Modifier = Modifier) {
    Column (modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier.fillMaxHeight(0.5f).weight(0.5f)) {
            QuadrantCard(
                modifier = modifier.weight(1f),
                color = Color(0xFFEADDFF),
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines."
            )

            QuadrantCard(
                modifier = modifier.weight(1f),
                color = Color(0xFFD0BCFF),
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object."
            )
        }
        Row(modifier = modifier.fillMaxHeight(0.5f).weight(0.5f)) {
            QuadrantCard(
                modifier = modifier.weight(1f),
                color = Color(0xFFB69DF8),
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence."
            )

            QuadrantCard(
                modifier = modifier.weight(1f),
                color = Color(0xFFF6EDFF),
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence."
            )
        }
    }
}

@Composable
fun QuadrantCard(modifier: Modifier, color: Color, title: String, description: String) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        ) {
        Column(
            modifier = modifier.padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = description,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    PracticeComposeBasicsTheme {
        QuadrantCardsContainer()
    }
}