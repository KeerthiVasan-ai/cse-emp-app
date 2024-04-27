package com.keerthi77459.cse_emp_app.login_feature

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseUser
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.login_feature.data.api.LoginState
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModel
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModelFactory
import com.keerthi77459.cse_emp_app.login_feature.presentation.screens.LoginScreen
import com.keerthi77459.cse_emp_app.main_features.HomeActivity
import com.keerthi77459.cse_emp_app.reset_password_features.ResetPasswordActivity
import com.keerthi77459.cse_emp_app.ui.theme.Cse_emp_appTheme

class LoginActivity : ComponentActivity() {

    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            Cse_emp_appTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    InitUI(viewModel) { startResetActivity() }
                }
            }
        }
        val factory = LoginViewModelFactory(Auth())
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]

        viewModel.loginState.observe(this) { loginState ->
            when (loginState) {
                is LoginState.Success -> {
                    startHomeActivity()
                }

                is LoginState.Error -> {
                    Toast.makeText(this, loginState.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun startResetActivity() {
        startActivity(Intent(this, ResetPasswordActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = Auth().auth.currentUser
        user?.let {
            startHomeActivity()
        }
    }
}

@Composable
fun InitUI(loginViewModel: LoginViewModel, reset: () -> Unit) {
    LoginScreen(loginViewModel, reset)
}