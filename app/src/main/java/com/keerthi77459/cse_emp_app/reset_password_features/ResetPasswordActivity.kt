package com.keerthi77459.cse_emp_app.reset_password_features

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.keerthi77459.cse_emp_app.login_feature.LoginActivity
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.login_feature.data.api.ResetState
import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModelFactory
import com.keerthi77459.cse_emp_app.reset_password_features.domain.view_model.ResetViewModel
import com.keerthi77459.cse_emp_app.reset_password_features.domain.view_model.ResetViewModelFactory
import com.keerthi77459.cse_emp_app.reset_password_features.presentation.screens.ResetPassword
import com.keerthi77459.cse_emp_app.reset_password_features.ui.theme.Cse_emp_appTheme

class ResetPasswordActivity : ComponentActivity() {

    private lateinit var viewModel: ResetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cse_emp_appTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ResetPassword(viewModel)
                }
            }
        }
        val factory = ResetViewModelFactory(Auth())
        viewModel = ViewModelProvider(this, factory)[ResetViewModel::class.java]

        viewModel.resetState.observe(this) {
            when (it) {
                is ResetState.Success -> {
                    startLoginActivity()
                    Toast.makeText(this, "Check your Inbox", Toast.LENGTH_LONG).show()

                }

                is ResetState.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}