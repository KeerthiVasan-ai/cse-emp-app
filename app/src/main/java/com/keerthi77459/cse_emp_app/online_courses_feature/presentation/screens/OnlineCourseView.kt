package com.keerthi77459.cse_emp_app.online_courses_feature.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
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
import com.keerthi77459.cse_emp_app.core.components.BuildFloatingActionButton
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.online_courses_feature.data.OnlineCoursesData
import com.keerthi77459.cse_emp_app.online_courses_feature.domain.services.FetchOnlineCourseDetails
import com.keerthi77459.cse_emp_app.online_courses_feature.presentation.components.BuildListView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnlineCoursesView(navController: NavController) {

    var onlineCourseDetails by remember { mutableStateOf<List<OnlineCoursesData>>(listOf()) }

    LaunchedEffect(Unit) {
        FetchOnlineCourseDetails().fetchDetails(
            onSuccess = { data ->
                onlineCourseDetails = data
            }, onFailure = {
                println(it.message)
            }
        )
    }

    println(onlineCourseDetails)

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Online Courses",
                showIcon = false,
                icon = Icons.Filled.Add
            ) {}
        },
        floatingActionButton = {
            BuildFloatingActionButton(icon = Icons.Filled.Add) {
                navController.navigate(NavigationScreen.OnlineCoursesScreen.route)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Styles().background)
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            LazyColumn {
                itemsIndexed(onlineCourseDetails) { _, data ->
                    BuildListView(onlineCoursesData = data)
                }
            }
        }
    }
}