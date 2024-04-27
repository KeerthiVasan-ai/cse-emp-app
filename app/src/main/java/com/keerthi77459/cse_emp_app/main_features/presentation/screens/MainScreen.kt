package com.keerthi77459.cse_emp_app.main_features.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.main_features.domain.model.MenuModel
import com.keerthi77459.cse_emp_app.main_features.domain.services.FetchUserDetails
import com.keerthi77459.cse_emp_app.main_features.presentation.components.BuildGridItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(context: Context, navController: NavController) {

    val auth = Auth().auth
    var name by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        FetchUserDetails().fetchUserName(
            onSuccess = { name = it },
            onFailure = {}
        )
    }

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Staff Sphere",
                showIcon = true,
                icon = Icons.AutoMirrored.Filled.Logout
            ) {
                auth.signOut()
                navController.navigate(NavigationScreen.LoginScreen.route) {
                    popUpTo(0) {}
                }
            }
        },
    ) {
        Column(
            modifier = Modifier
                .background(brush = Styles().background)
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                "Welcome! $name",
                style = Styles().bigText,
                modifier = Modifier.padding(top = 24.dp, start = 16.dp)
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                columns = GridCells.Fixed(2)
            ) {
                itemsIndexed(MenuModel.menuList) { _, item ->
                    BuildGridItems(
                        data = item,
                        navController = navController,
                        context = context
                    )
                }
            }
        }
    }
}