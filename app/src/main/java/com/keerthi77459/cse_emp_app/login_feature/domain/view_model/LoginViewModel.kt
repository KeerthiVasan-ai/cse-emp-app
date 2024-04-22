package com.keerthi77459.cse_emp_app.login_feature.domain.view_model

import androidx.lifecycle.ViewModel
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth

class LoginViewModel(private val auth: Auth) : ViewModel() {
    val loginState = auth.loginState

    fun login(username: String, password: String) {
        auth.userLogin(username, password)
    }
}
