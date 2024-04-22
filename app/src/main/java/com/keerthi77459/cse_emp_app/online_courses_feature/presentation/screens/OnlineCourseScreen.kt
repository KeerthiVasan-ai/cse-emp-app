package com.keerthi77459.cse_emp_app.online_courses_feature.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.online_courses_feature.data.OnlineCoursesData
import com.keerthi77459.cse_emp_app.online_courses_feature.domain.services.InsertOnlineCourseDetails

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnlineCoursesScreen(navController: NavController) {

    var validateDetails by remember {
        mutableStateOf(
            listOf(
                true,
                true,
                true,
                true
            )
        )
    }
    var course by remember { mutableStateOf("") }
    var offered by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Online Course Details Form",
                showIcon = false,
                icon = Icons.Filled.Add
            ) {}
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BuildTextField(
                        value = course,
                        onValueChange = { course = it },
                        showError = !validateDetails[0],
                        readOnly = false,
                        label = "Name of the Course"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    BuildTextField(
                        value = offered,
                        onValueChange = { offered = it },
                        showError = !validateDetails[1],
                        readOnly = false,
                        label = "Course Offered By"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(Modifier.weight(1f)) {
                            startDate = buildDatePicker(
                                date = "",
                                label = "Start Date",
                                showError = !validateDetails[2],
                                isEditing = true
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Box(Modifier.weight(1f)) {
                            endDate = buildDatePicker(
                                date = "", label = "End Date",
                                showError = !validateDetails[3],
                                isEditing = true
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    BuildButton {
                        validateDetails = validate(
                            course = course,
                            offered = offered,
                            startDate = startDate,
                            endDate = endDate
                        )
                        val isValidated = validateDetails.all { it }
                        if (isValidated) {
                            InsertOnlineCourseDetails().insertOnlineCourseDetails(
                                OnlineCoursesData(
                                    course,
                                    offered,
                                    startDate,
                                    endDate
                                )
                            )
                            navController.navigate(NavigationScreen.OnlineCoursesView.route) {
                                popUpTo(NavigationScreen.OnlineCoursesView.route) {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun validate(course: String, offered: String, startDate: String, endDate: String): List<Boolean> {
    return listOf(
        course.isNotBlank(),
        offered.isNotBlank(),
        startDate.isNotBlank(),
        endDate.isNotBlank()
    )
}