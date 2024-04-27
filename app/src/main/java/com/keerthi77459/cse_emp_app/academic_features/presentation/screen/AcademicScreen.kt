package com.keerthi77459.cse_emp_app.academic_features.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AcademicData
import com.keerthi77459.cse_emp_app.academic_features.domain.services.FetchAcademicsDetail
import com.keerthi77459.cse_emp_app.academic_features.presentation.components.AcademicScreenForm
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildFloatingActionButton
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.core.styles.Styles

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AcademicScreen(navController: NavController) {

    var academicData by remember { mutableStateOf<AcademicData?>(null) }
    var editing by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        FetchAcademicsDetail().fetchDetails(
            onSuccess = { data ->
                academicData = data
            }, onFailure = {
                println(it.message)
            }
        )
    }

    println(academicData?.joiningDate)


    var joiningDate by remember { mutableStateOf("") }
    var meAwarded by remember { mutableStateOf("") }
    var phdAwarded by remember { mutableStateOf("") }
    var meGuide by remember { mutableStateOf("") }
    var phdGuide by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            BuildFloatingActionButton(icon = Icons.Filled.Add) {
                navController.navigate(NavigationScreen.AcademicScreen.route)
            }
        },

        topBar = {
            BuildAppBar(
                title = "Academic Details",
                showIcon = true,
                icon = Icons.Filled.EditNote
            ) {
                editing = !editing
            }
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Styles().background)
                .padding(paddingValues = paddingValue),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            academicData?.let { data ->
                AcademicScreenForm(

                    editing = editing,
                    navController = navController,

                    joiningDate = data.joiningDate,
                    meAwarded = data.mPhilAwarded,
                    phdAwarded = data.phdAwarded,
                    meGuide = data.mPhilGuide,
                    phdGuided = data.phdGuide,

                    onJoiningDateChange = { joiningDate = it },
                    onMeAwardedChange = { meAwarded = it },
                    onPhdAwardedChange = { phdAwarded = it },
                    onMeGuideChange = { meGuide = it },
                    onPhdGuideChange = { phdGuide = it },

                    onEditingChange = { editing = it },

                    attendedCount = data.attendedCount,
                    conductedCount = data.conductedCount,
                )
            }
        }
    }
}

@Preview
@Composable
fun AcademicPreview() {
    AcademicScreen(navController = rememberNavController())
}