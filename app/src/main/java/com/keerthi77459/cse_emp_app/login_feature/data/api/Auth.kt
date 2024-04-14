package com.keerthi77459.cse_emp_app.login_feature.data.api

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth

class Auth {
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var loginState = MutableLiveData<LoginState>()
    fun userLogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    loginState.postValue(LoginState.Success)
                } else {
                    loginState.postValue(LoginState.Error("Invalid Credentials"))
                }
            }
    }
}

sealed class LoginState {
    data object Success : LoginState()
    data class Error(val message: String) : LoginState()
}