package br.com.portal.basicstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter() {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter( count = count, onIncrement = { count++ }, modifier =  Modifier )
}

@Composable
private fun StatelessCounter( count: Int,
                              onIncrement:() -> Unit,
                              modifier: Modifier = Modifier ) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You`ve had ${count} glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }
    }
}