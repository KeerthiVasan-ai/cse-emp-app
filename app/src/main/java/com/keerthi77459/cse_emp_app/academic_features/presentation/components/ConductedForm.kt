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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.academic_features.data.repository.ConductedData
import com.keerthi77459.cse_emp_app.academic_features.domain.services.InsertEventData
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen

@Composable
fun ConductedForm(navController: NavController, event: String, year: String) {

    var validateDetails by remember {
        mutableStateOf(
            listOf(true, true, true)
        )
    }

    var name by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
                        showError = !validateDetails[1]
                    )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(Modifier.weight(1f)) {
                endDate =
                    buildDatePicker(
                        date = endDate,
                        label = "End Date",
                        isEditing = true,
                        showError = !validateDetails[2]
                    )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        BuildButton {
            validateDetails = validate(name, startDate, endDate)
            val isValidated = validateDetails.all { it }
            if (isValidated) {
                InsertEventData().insertConductedData(
                    ConductedData(
                        event, year, name, startDate, endDate
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


fun validate(name: String, startDate: String, endDate: String): List<Boolean> {
    return listOf(
        name.isNotBlank(),
        startDate.isNotBlank(),
        endDate.isNotBlank()
    )
}
