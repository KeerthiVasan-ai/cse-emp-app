package com.keerthi77459.cse_emp_app.core.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BuildTextField(value: String, onValueChange: (String) -> Unit,readOnly:Boolean,label: String) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        readOnly = readOnly
    )
}

@Preview(showBackground = true)
@Composable
fun BuildTextFieldPreview(){
    BuildTextField(value = "KEERTHIVASAN S", onValueChange = {}, readOnly = true, label = "Name")
}