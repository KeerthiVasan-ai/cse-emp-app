package com.keerthi77459.cse_emp_app.login_feature.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.core.components.BuildDivider
import com.keerthi77459.cse_emp_app.login_feature.domain.model.InputType
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModel
import com.keerthi77459.cse_emp_app.login_feature.presentation.components.BuildButton
import com.keerthi77459.cse_emp_app.login_feature.presentation.components.buildTextField

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val passwordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.logo), null, Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop
        )
        userName = buildTextField(InputType.Name, keyboardActions = KeyboardActions(onNext = {
            passwordFocusRequester.requestFocus()
        }))
        password = buildTextField(InputType.Password, keyboardActions = KeyboardActions(onNext = {
            focusManager.clearFocus()
        }), focusRequester = passwordFocusRequester)
        BuildButton(loginViewModel, userName, password)
        BuildDivider()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Forget your credentials?", color = Color.Black)
            TextButton(onClick = {}) {
                Text("RESET PASSWORD")
            }
        }
    }
}