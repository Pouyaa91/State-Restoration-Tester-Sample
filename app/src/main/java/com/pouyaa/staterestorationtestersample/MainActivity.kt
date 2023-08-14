package com.pouyaa.staterestorationtestersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pouyaa.staterestorationtestersample.ui.theme.StateRestorationTesterSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateRestorationTesterSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClickCounter()
                }
            }
        }
    }
}

@Composable
fun ClickCounter(modifier: Modifier = Modifier) {
    var saveableCount by rememberSaveable { mutableStateOf(0) }
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Saveable count: $saveableCount",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Count: $count",
            style = MaterialTheme.typography.headlineSmall
        )

        Button(
            onClick = {
                saveableCount++
                count++
            }
        ) {
            Text(text = "Add 1", style = MaterialTheme.typography.titleLarge)
        }
    }
}

