package com.keerthi77459.cse_emp_app.academic_features.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.academic_features.presentation.components.AttendedForm
import com.keerthi77459.cse_emp_app.academic_features.presentation.components.ConductedForm
import com.keerthi77459.cse_emp_app.core.components.buildDropDownMenu

@Composable
fun AcademicDetailsForm() {

    var selectedText by remember { mutableStateOf("") }
    var modeOfProgramme by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

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
                selectedText = buildDropDownMenu(
                    "Select the Programme",
                    listOf("Seminar", "Workshop", "FDP", "STTP")
                )
                year = buildDropDownMenu(
                    label = "Year",
                    menus = listOf("2021-2022", "2022-2023", "2023-2024", "2024-2025")
                )
                modeOfProgramme = buildDropDownMenu(
                    label = "Attended or Conducted",
                    menus = listOf("Attended", "Conducted")
                )

                when (modeOfProgramme) {
                    "Attended" -> AttendedForm(selectedText, year, modeOfProgramme)
                    "Conducted" -> ConductedForm(selectedText, year, modeOfProgramme)
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AcademicDetailFormPreview() {
    AcademicDetailsForm()
}