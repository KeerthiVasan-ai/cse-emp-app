package com.keerthi77459.cse_emp_app.login_feature.data.api

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


class Auth {
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var loginState = MutableLiveData<LoginState>()
    var resetState = MutableLiveData<ResetState>()
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

    fun resetPassword(userName: String) {
        auth.sendPasswordResetEmail(userName)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    resetState.postValue(ResetState.Success)
                } else {
                    resetState.postValue(ResetState.Error("Invalid Credentials"))
                }
            }
    }
}

sealed class LoginState {
    data object Success : LoginState()
    data class Error(val message: String) : LoginState()
}

sealed class ResetState {
    data object Success : ResetState()
    data class Error(val message: String) : ResetState()
}