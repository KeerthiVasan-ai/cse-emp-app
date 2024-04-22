package com.keerthi77459.cse_emp_app.core.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.keerthi77459.cse_emp_app.core.styles.Styles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildAppBar(
    title: String,
    showIcon: Boolean = false,
    icon: ImageVector,
    onAction: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title, style = Styles().appBarTextStyle) },
        actions = {
            if (showIcon) {
                IconButton(onClick = onAction) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                }
            }
        },
    )
}