package com.keerthi77459.cse_emp_app.main_features.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.main_features.domain.model.MenuModel
import com.keerthi77459.cse_emp_app.main_features.presentation.components.BuildGridItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(context: Context, navController: NavController) {

    val auth = Auth().auth
    Scaffold(
        topBar = {
            BuildAppBar(title = "Staff Sphere", icon = R.drawable.baseline_logout_24) {
                auth.signOut()
            }
        },
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                "Welcome ${auth.uid}",
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 24.dp, start = 16.dp)
            )
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
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