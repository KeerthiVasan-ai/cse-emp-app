package com.keerthi77459.cse_emp_app.core.components

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BuildButton(onClick: () -> Unit) {
    OutlinedButton(onClick = onClick) {
        Text(text = "Save the Data")
    }
}