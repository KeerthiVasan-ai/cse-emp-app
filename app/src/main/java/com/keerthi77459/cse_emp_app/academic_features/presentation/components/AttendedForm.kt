package com.keerthi77459.cse_emp_app.academic_features.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
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
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AttendedData
import com.keerthi77459.cse_emp_app.academic_features.domain.services.InsertEventData
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen

@Composable
fun AttendedForm(navController: NavController, event: String, year: String) {

    var validateDetails by remember {
        mutableStateOf(
            listOf(
                true, true, true, true
            )
        )
    }

    var name by remember { mutableStateOf("") }
    var organized by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = name,
            onValueChange = { name = it },
            showError = !validateDetails[0],
            readOnly = false,
            label = "Name of the Programme"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = organized,
            onValueChange = { organized = it },
            showError = !validateDetails[1],
            readOnly = false,
            label = "Organized By"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(Modifier.weight(1f)) {
                startDate =
                    buildDatePicker(
                        date = startDate,
                        label = "Start Date",
                        isEditing = true,
                        showError = !validateDetails[2]
                    )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(Modifier.weight(1f)) {
                endDate =
                    buildDatePicker(
                        date = endDate,
                        label = "End Date",
                        isEditing = true,
                        showError = !validateDetails[3]
                    )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        BuildButton {
            validateDetails = validate(
                name = name,
                organized = organized,
                startDate = startDate,
                endDate = endDate
            )
            println(validateDetails)
            val isValidated = validateDetails.all { it }
            println(isValidated)
            if (isValidated) {
                InsertEventData().insertAttendedData(
                    AttendedData(
                        event, year, name, organized, startDate, endDate
                    )
                )
                navController.navigate(NavigationScreen.AcademicView.route) {
                    popUpTo(NavigationScreen.AcademicView.route) {
                        inclusive = true
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

fun validate(name: String, organized: String, startDate: String, endDate: String): List<Boolean> {
    return listOf(
        name.isNotBlank(),
        organized.isNotBlank(),
        startDate.isNotBlank(),
        endDate.isNotBlank()
    )
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    AttendedForm(rememberNavController(), event = "Seminar", "2021-2022")
}
