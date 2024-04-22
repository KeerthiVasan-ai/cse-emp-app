package com.keerthi77459.cse_emp_app.academic_features.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.keerthi77459.cse_emp_app.academic_features.presentation.components.AttendedForm
import com.keerthi77459.cse_emp_app.academic_features.presentation.components.ConductedForm
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.buildDropDownMenu
import com.keerthi77459.cse_emp_app.core.styles.Styles

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AcademicDetailsForm(navController: NavController) {

    var selectedText by remember { mutableStateOf("") }
    var modeOfProgramme by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Academic Details Form",
                showIcon = false,
                icon = Icons.Filled.Add
            ) {}
        }
    ) {
        Column(
            modifier = Modifier
                .background(brush = Styles().background)
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(text = "Furnish this Details", style = Styles().mediumText)
                        Spacer(modifier = Modifier.height(24.dp))
                        selectedText = buildDropDownMenu(
                            "Select the Programme",
                            listOf("Seminar", "Workshop", "FDP", "STTP")
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        year = buildDropDownMenu(
                            label = "Year",
                            menus = listOf("2021-2022", "2022-2023", "2023-2024", "2024-2025")
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        modeOfProgramme = buildDropDownMenu(
                            label = "Attended or Conducted",
                            menus = listOf("Attended", "Conducted")
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        when (modeOfProgramme) {
                            "Attended" -> {
                                if (selectedText.isNotBlank() && year.isNotBlank() && modeOfProgramme.isNotBlank()) {
                                    AttendedForm(navController, selectedText, year)
                                }
                            }

                            "Conducted" -> {
                                if (selectedText.isNotBlank() && year.isNotBlank() && modeOfProgramme.isNotBlank()) {
                                    ConductedForm(navController, selectedText, year)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AcademicDetailFormPreview() {
    AcademicDetailsForm(rememberNavController())
}