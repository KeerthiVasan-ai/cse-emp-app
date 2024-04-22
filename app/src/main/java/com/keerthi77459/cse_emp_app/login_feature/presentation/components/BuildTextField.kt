package com.keerthi77459.cse_emp_app.login_feature.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.login_feature.domain.model.InputType
import com.keerthi77459.cse_emp_app.ui.theme.Shapes

@Composable
fun BuildTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    inputType: InputType,
    showError: Boolean = false,
    isPasswordField: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityChange: (Boolean) -> Unit = {},
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions
) {

    Column {
        TextField(
            value = value,
            onValueChange = { onValueChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester ?: FocusRequester()),
            label = { Text(text = inputType.label) },
            leadingIcon = {
                Icon(
                    imageVector = inputType.icon,
                    null,
                    tint = if (showError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
            },
            shape = Shapes.small,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
            isError = showError,
            trailingIcon = {
                if (showError && !isPasswordField) {
                    Icon(imageVector = Icons.Outlined.Error, contentDescription = null)
                }
                if (isPasswordField) {
                    IconButton(onClick = { onVisibilityChange(!isPasswordVisible) }) {
                        if (isPasswordVisible) {
                            Icon(imageVector = Icons.Default.Visibility, contentDescription = null)
                        } else {
                            Icon(
                                imageVector = Icons.Default.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    }
                }
            },
            keyboardOptions = inputType.keyboardOptions,
            visualTransformation = when {
                isPasswordField && isPasswordVisible -> VisualTransformation.None
                isPasswordField -> PasswordVisualTransformation()
                else -> VisualTransformation.None

            },
            keyboardActions = keyboardActions
        )
        if (showError) {
            Text(
                text = inputType.errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .offset(y = 8.dp)
                    .fillMaxWidth(0.9f)
            )
        }
    }
}