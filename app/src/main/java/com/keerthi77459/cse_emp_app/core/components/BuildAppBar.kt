package com.keerthi77459.cse_emp_app.core.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildAppBar(title: String, @DrawableRes icon: Int, onAction: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = onAction) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Logout"
                )
            }
        },
    )
}