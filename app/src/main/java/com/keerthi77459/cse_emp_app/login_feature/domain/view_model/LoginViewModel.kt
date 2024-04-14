package com.keerthi77459.cse_emp_app.login_feature.domain.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Auth) : ViewModel() {
    val loginState = repository.loginState

    fun login(username: String, password: String) {
        repository.userLogin(username, password)
    }
}
