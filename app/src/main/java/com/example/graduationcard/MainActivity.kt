package com.example.graduationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graduationcard.R.string.HappyGraduationText
import com.example.graduationcard.R.string.HopeText
import com.example.graduationcard.R.string.SenderText
import com.example.graduationcard.ui.theme.GraduationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraduationCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreatingImage(
                        massage = stringResource(HappyGraduationText),
                        hope = stringResource(HopeText),
                        sender = stringResource(SenderText),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreatingImage(massage: String, hope: String, sender: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.background)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        GreatingText(
            massage = massage,
            hope = hope,
            sender = sender,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun GreatingText(massage: String, hope:  String, sender: String,  modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center, modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()) {
        Text(
            text = massage,
            fontSize = 60.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = hope,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(all = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = sender,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(all = 16.dp)
                .align(Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraduationCardTheme {
        GreatingImage(massage = "Happy Graduation Tino", hope = "Semoga Sukses Selalu", sender = " From Tino")
    }
}