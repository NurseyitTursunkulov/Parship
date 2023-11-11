package com.example.parship.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.parship.ButtonViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Created by nurseiit.tursunkulov on 11.11.23.
 */

@Composable
fun ParshipScreen(viewModel: ButtonViewModel = koinViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        ParshipText(name = viewModel.screenState.collectAsStateWithLifecycle().value.title, modifier = Modifier.align(Alignment.Center))
        OutlinedButton(onClick = { viewModel.toggleText() }, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text("Toggle")
        }
    }
}

@Composable
fun ParshipText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        style = MaterialTheme.typography.displayLarge.copy(
            fontWeight = FontWeight.SemiBold,
        ),
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    )
}