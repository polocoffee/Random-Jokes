package com.banklannister.randomjokes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.banklannister.randomjokes.ui.theme.RandomJokesTheme
import com.banklannister.randomjokes.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            RandomJokesTheme {

                val viewModels by viewModels<MainViewModel>()
                MainScreen(viewModels)
            }
        }
    }
}


@Composable
fun MainScreen(viewModel: MainViewModel) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(top = 70.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = "Random Jokes",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            viewModel.joke.value?.joke?.let { jokesText ->

                Text(
                    text = jokesText,
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(20.dp)
                )
            }

                Spacer(Modifier.height(10.dp))

                Button(
                    onClick = {
                        viewModel.getJokes()
                    }
                ) {
                    Text(text = "Random Jokes")
                }
            }

        }

    }



