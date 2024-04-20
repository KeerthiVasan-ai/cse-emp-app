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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker

@Composable
fun AttendedForm(nameOfProgramme: String, year: String, mode: String) {
    var name by remember { mutableStateOf("") }
    var organized by remember { mutableStateOf("") }
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
            readOnly = false,
            label = "Name of the Programme"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = organized,
            onValueChange = { organized = it },
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
                    buildDatePicker(date = startDate, label = "Start Date", isEditing = true)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(Modifier.weight(1f)) {
                endDate =
                    buildDatePicker(date = endDate, label = "End Date", isEditing = true)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    AttendedForm(nameOfProgramme = "Seminar", "2021-2022", mode = "Conducted")
}
