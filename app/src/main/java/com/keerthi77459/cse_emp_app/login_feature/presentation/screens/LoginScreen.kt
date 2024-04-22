package com.keerthi77459.cse_emp_app.login_feature.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildDivider
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.login_feature.domain.model.InputType
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModel
import com.keerthi77459.cse_emp_app.login_feature.presentation.components.BuildTextField

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val passwordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var validateDetailsList by remember { mutableStateOf(listOf(true, true)) }

    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        Modifier
            .background(brush = Styles().background)
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
        BuildTextField(
            value = userName,
            onValueChanged = { userName = it },
            inputType = InputType.Name,
            showError = !validateDetailsList[0],
            keyboardActions = KeyboardActions(onNext = {
                passwordFocusRequester.requestFocus()
            })
        )
        BuildTextField(
            value = password,
            onValueChanged = { password = it },
            inputType = InputType.Password,
            isPasswordField = true,
            showError = !validateDetailsList[1],
            isPasswordVisible = isPasswordVisible,
            onVisibilityChange = { isPasswordVisible = it },
            keyboardActions = KeyboardActions(onNext = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester
        )
        BuildButton("LOGIN"){
            validateDetailsList = validate(userName, password)
            if ((validateDetailsList[0] && validateDetailsList[1])) {
                loginViewModel.login(userName, password)
            }
        }
        BuildDivider()
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Text("Forget your credentials?", color = Color.Black)
//            TextButton(onClick = {}) {
//                Text("RESET PASSWORD")
//            }
//        }
    }
}


fun validate(userName: String, password: String): List<Boolean> {
    var validateUserNameCheck by mutableStateOf(true)
    var validatePasswordCheck by mutableStateOf(true)

    validateUserNameCheck = userName.isNotBlank()
    validatePasswordCheck = password.isNotBlank()

    return listOf(validateUserNameCheck, validatePasswordCheck)
}