package com.keerthi77459.cse_emp_app.main_features

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.keerthi77459.cse_emp_app.core.navigation.NavigationMap
import com.keerthi77459.cse_emp_app.main_features.presentation.screens.MainScreen
import com.keerthi77459.cse_emp_app.ui.theme.Cse_emp_appTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cse_emp_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationMap(this)
                }
            }
        }
    }
}


