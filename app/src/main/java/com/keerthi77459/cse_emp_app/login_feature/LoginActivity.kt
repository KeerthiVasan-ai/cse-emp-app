package com.keerthi77459.cse_emp_app.login_feature

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseUser
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.login_feature.data.api.LoginState
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModel
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModelFactory
import com.keerthi77459.cse_emp_app.login_feature.presentation.screens.LoginScreen
import com.keerthi77459.cse_emp_app.main_features.HomeActivity
import com.keerthi77459.cse_emp_app.ui.theme.Cse_emp_appTheme

class LoginActivity : ComponentActivity() {

    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cse_emp_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InitUI()
                }
            }
        }
        val factory = LoginViewModelFactory(Auth())
        viewModel = ViewModelProvider(this,factory).get(LoginViewModel::class.java)

        viewModel.loginState.observe(this) { loginState ->
            when (loginState) {
                is LoginState.Success -> {
                    startHomeActivity()
                }

                is LoginState.Error -> {
                    Toast.makeText(this, loginState.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @Composable
    fun InitUI() {
        LoginScreen(viewModel)
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = Auth().auth.currentUser
        user?.let {
            startHomeActivity()
        }
    }
}