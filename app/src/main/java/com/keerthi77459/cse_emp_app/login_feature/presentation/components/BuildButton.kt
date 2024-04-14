package com.keerthi77459.cse_emp_app.login_feature.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModel

@Composable
fun BuildButton(loginViewModel: LoginViewModel, email: String, password: String) {

    Button(
        onClick = { loginViewModel.login(email, password) },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("SIGN IN", Modifier.padding(vertical = 8.dp))
    }
}