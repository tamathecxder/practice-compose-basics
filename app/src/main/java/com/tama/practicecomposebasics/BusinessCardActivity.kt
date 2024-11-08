package com.tama.practicecomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tama.practicecomposebasics.ui.theme.PracticeComposeBasicsTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeComposeBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .background(Color(0xFFDAE5DB))
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MainInformation(modifier = Modifier.weight(0.7f))
        ContactInformation(modifier = Modifier.weight(0.3f))
    }
}

private const val primaryColor = 0xFF1B2E37

@Composable
fun MainInformation(modifier: Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .background(Color(primaryColor))
                .width(100.dp)
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = image,
                contentDescription = "Android Icon",
                contentScale = ContentScale.Fit,
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "John Doe",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 38.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 14.sp,
            )
        }
    }
}

@Composable()
fun ContactInformation(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ContactItem(text = "+11 (123) 444 6342414", Icons.Rounded.Call, "Call Icon")
        ContactItem(text = "@johandoe", Icons.Rounded.AccountCircle, "Handle Icon")
        ContactItem(text = "johndoe@testing.dev", Icons.Rounded.Email, "Email Icon")
    }
}

@Composable
fun ContactItem(text: String, icon: ImageVector, desc: String?) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(0.4f), horizontalAlignment = Alignment.End) {
            Icon(
                icon,
                contentDescription = desc,
                tint = Color(primaryColor),
                modifier = Modifier.size(18.dp),
            )
        }

        Spacer(Modifier.size(10.dp))

        Column(Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
            Text(
                text,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 10.dp),
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    PracticeComposeBasicsTheme {
        BusinessCardApp()
    }
}