package com.tama.practicecomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
                    QuadrantCardsContainer()
                }
            }
        }
    }
}

@Composable
fun QuadrantCardsContainer() {
    Column (Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                modifier = Modifier.weight(1f),
                color = Color(0xFFEADDFF),
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description)
            )

            QuadrantCard(
                modifier = Modifier.weight(1f),
                color = Color(0xFFD0BCFF),
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                modifier = Modifier.weight(1f),
                color = Color(0xFFB69DF8),
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description)
            )

            QuadrantCard(
                modifier = Modifier.weight(1f),
                color = Color(0xFFF6EDFF),
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description)
            )
        }
    }
}

@Composable
fun QuadrantCard(modifier: Modifier, color: Color, title: String, description: String) {
    Column(
        modifier = modifier
            .background(color)
            .fillMaxSize()
            .padding(16.dp),
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    PracticeComposeBasicsTheme {
        QuadrantCardsContainer()
    }
}