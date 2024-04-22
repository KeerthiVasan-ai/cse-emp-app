package com.keerthi77459.cse_emp_app.academic_features.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AcademicData
import com.keerthi77459.cse_emp_app.academic_features.domain.services.FetchAcademicsDetail
import com.keerthi77459.cse_emp_app.academic_features.presentation.components.AcademicScreenForm
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildFloatingActionButton
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AcademicScreen(navController: NavController) {

    var academicData by remember { mutableStateOf<AcademicData?>(null) }

    LaunchedEffect(Unit) {
        FetchAcademicsDetail().fetchDetails(
            onSuccess = { data ->
                academicData = data
            },
            onFailure = { _ ->

            }
        )
    }
    Scaffold(
        floatingActionButton = {
            BuildFloatingActionButton(icon = Icons.Filled.Add) {
                navController.navigate(NavigationScreen.AcademicScreen.route)
            }
        },

        topBar = {
            BuildAppBar(
                title = "Academic Details",
                showIcon = false,
                icon = Icons.Filled.Add
            ) {}
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValues = paddingValue),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            academicData?.let { data ->

                AcademicScreenForm(
                    joiningDate = data.joiningDate,
                    meAwarded = data.mPhilAwarded,
                    phdAwarded = data.phdAwarded,
                    meGuide = data.mPhilGuide,
                    phdGuided = data.phdGuide,
                    attendedCount = data.attendedCount,
                    conductedCount = data.conductedCount
                )
            }
        }
    }
}