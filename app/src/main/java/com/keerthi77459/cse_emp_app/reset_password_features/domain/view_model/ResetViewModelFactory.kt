package com.keerthi77459.cse_emp_app.reset_password_features.domain.view_model

import com.keerthi77459.cse_emp_app.login_feature.domain.view_model.LoginViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth

class ResetViewModelFactory(private val repository: Auth) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResetViewModel::class.java)) {
            return ResetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
