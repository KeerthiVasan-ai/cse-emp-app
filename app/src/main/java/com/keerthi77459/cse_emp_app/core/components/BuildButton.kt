package com.keerthi77459.cse_emp_app.core.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.ui.theme.Shapes

@Composable
fun BuildButton(buttonText: String = "Submit", onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = Shapes.medium,
        contentPadding = PaddingValues(),
        onClick = { onClick() })
    {
        Text(text = buttonText, style = Styles().mediumText)
    }
}

@Preview
@Composable
fun BuildButtonPreview() {
    BuildButton {}
}