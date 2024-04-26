package com.keerthi77459.cse_emp_app.reset_password_features.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.login_feature.domain.model.InputType
import com.keerthi77459.cse_emp_app.login_feature.presentation.components.BuildTextField
import com.keerthi77459.cse_emp_app.reset_password_features.domain.view_model.ResetViewModel

@Composable
fun ResetPassword(resetViewModel: ResetViewModel) {

    val focusManager = LocalFocusManager.current
    var userName by remember { mutableStateOf("") }

    var validateDetails by remember { mutableStateOf(listOf(true)) }

    Column(
        Modifier
            .background(brush = Styles().background)
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.logo), null, Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop
        )
        Text(text = "Reset your Password", style = Styles().bigText)
        Spacer(modifier = Modifier.height(24.dp))
        BuildTextField(
            value = userName,
            onValueChanged = { userName = it },
            inputType = InputType.Name,
            showError = !validateDetails[0],
            keyboardActions = KeyboardActions(onNext = {
                focusManager.clearFocus()
            })
        )
        Spacer(modifier = Modifier.height(16.dp))
        BuildButton("LOGIN") {
            validateDetails = validate(userName)
            if ((validateDetails[0])) {
                resetViewModel.reset(userName)
            }
        }
    }
}

fun validate(userName: String): List<Boolean> {
    var validateUserNameCheck by mutableStateOf(true)

    validateUserNameCheck = userName.isNotBlank()

    return listOf(validateUserNameCheck)
}