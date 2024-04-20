package com.keerthi77459.cse_emp_app.core.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BuildFloatingActionButton(icon: ImageVector, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Icon(icon, "")
    }
}