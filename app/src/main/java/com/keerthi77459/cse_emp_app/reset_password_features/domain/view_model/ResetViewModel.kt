package com.keerthi77459.cse_emp_app.reset_password_features.domain.view_model

import androidx.lifecycle.ViewModel
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth

class ResetViewModel(private val auth: Auth) : ViewModel() {
    val resetState = auth.resetState

    fun reset(userName: String) {
        auth.resetPassword(userName)
    }
}