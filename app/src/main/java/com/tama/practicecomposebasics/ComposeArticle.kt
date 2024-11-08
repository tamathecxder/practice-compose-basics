package com.tama.practicecomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tama.practicecomposebasics.ui.theme.PracticeComposeBasicsTheme

class ComposeArticle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeComposeBasicsTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleContainer(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ArticleContainer(modifier: Modifier = Modifier) {
    val textModifier = modifier.padding(top = 16.dp)

    Column {
        BannerImage()
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.header_text),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = stringResource(R.string.first_paragraph_text),
                textModifier,
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(R.string.second_paragraph_text),
                textModifier,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun BannerImage() {
    val image = painterResource(R.drawable.bg_compose_background)

    Image (
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PracticeComposeBasicsTheme {
        ArticleContainer()
    }
}