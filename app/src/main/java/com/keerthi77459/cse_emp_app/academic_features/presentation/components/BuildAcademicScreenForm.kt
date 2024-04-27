package com.keerthi77459.cse_emp_app.academic_features.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AcademicData
import com.keerthi77459.cse_emp_app.academic_features.domain.services.UpdateAcademicsDetails
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AcademicScreenForm(
    editing: Boolean,
    navController: NavController,

    joiningDate: String,
    meAwarded: String,
    phdAwarded: String,
    meGuide: String,
    phdGuided: String,

    onJoiningDateChange: (String) -> Unit,
    onMeAwardedChange: (String) -> Unit,
    onPhdAwardedChange: (String) -> Unit,
    onMeGuideChange: (String) -> Unit,
    onPhdGuideChange: (String) -> Unit,

    onEditingChange: (Boolean) -> Unit,

    conductedCount: String,
    attendedCount: String,
) {
    var editedJoiningDate by remember { mutableStateOf(joiningDate) }
    var editedMeAwarded by remember { mutableStateOf(meAwarded) }
    var editedPhdAwarded by remember { mutableStateOf(phdAwarded) }
    var editedMeGuide by remember { mutableStateOf(meGuide) }
    var editedPhdGuided by remember { mutableStateOf(phdGuided) }

    var validateDetails by remember {
        mutableStateOf(
            listOf(
                true, true, true,
                true, true
            )
        )
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
    ) {
        if (editing) {
            editedJoiningDate = buildDatePicker(
                date = editedJoiningDate,
                label = "Date of Joining",
                isEditing = true,
                showError = !validateDetails[0]
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedMeAwarded,
                onValueChange = { editedMeAwarded = it },
                readOnly = false,
                showError = !validateDetails[1],
                label = "M.E Awarded"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedPhdAwarded,
                onValueChange = { editedPhdAwarded = it },
                readOnly = false,
                showError = !validateDetails[2],
                label = "Phd Awarded"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedMeGuide,
                onValueChange = { editedMeGuide = it },
                readOnly = false,
                showError = !validateDetails[3],
                label = "M.E Guidance"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedPhdGuided,
                onValueChange = { editedPhdGuided = it },
                readOnly = false,
                showError = !validateDetails[4],
                label = "Phd Guidance"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = conductedCount,
                onValueChange = {},
                readOnly = true,
                label = "Seminars/Workshop/FDP/STTP Conducted"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = attendedCount,
                onValueChange = {},
                readOnly = true,
                label = "Seminars/Workshop/FDP/STTP Attended"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildButton("Update") {
                validateDetails = validate(
                    joiningDate = editedJoiningDate,
                    meAwarded = editedMeAwarded,
                    phdAwarded = editedPhdAwarded,
                    meGuide = editedMeGuide,
                    phdGuided = editedPhdGuided,
                    conductedCount = conductedCount,
                    attendedCount = attendedCount
                )
                val isValidated = validateDetails.all { it }
                if (isValidated) {
                    UpdateAcademicsDetails().updateAcademicsDetails(
                        AcademicData(
                            joiningDate = editedJoiningDate,
                            mPhilAwarded = editedMeAwarded,
                            phdAwarded = editedPhdAwarded,
                            mPhilGuide = editedMeGuide, phdGuide = editedPhdGuided,
                            attendedCount = attendedCount, conductedCount = conductedCount
                        )
                    )
                    onJoiningDateChange(editedJoiningDate)
                    onMeAwardedChange(editedMeAwarded)
                    onPhdAwardedChange(editedPhdAwarded)
                    onMeGuideChange(editedMeGuide)
                    onPhdGuideChange(editedPhdGuided)

                    onEditingChange(!editing)

                    navController.navigate(NavigationScreen.AcademicView.route) {
                        popUpTo(NavigationScreen.AcademicView.route) {
                            inclusive = true
                        }
                    }
                }
            }
        } else {
            BuildTextField(
                value = joiningDate,
                onValueChange = {},
                readOnly = true,
                label = "Date of Joining"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = meAwarded,
                onValueChange = {},
                readOnly = true,
                label = "M.E Awarded"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = phdAwarded,
                onValueChange = {},
                readOnly = true,
                label = "Phd Awarded"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = meGuide,
                onValueChange = {},
                readOnly = true,
                label = "M.E Guidance"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = phdGuided,
                onValueChange = {},
                readOnly = true,
                label = "Phd Guidance"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = conductedCount,
                onValueChange = {},
                readOnly = true,
                label = "Seminars/Workshop/FDP/STTP Conducted"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = attendedCount,
                onValueChange = {},
                readOnly = true,
                label = "Seminars/Workshop/FDP/STTP Attended"
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

fun validate(
    joiningDate: String,
    meAwarded: String,
    phdAwarded: String,
    meGuide: String,
    phdGuided: String,
    conductedCount: String,
    attendedCount: String,
): List<Boolean> {
    return listOf(
        joiningDate.isNotBlank(),
        meAwarded.isNotBlank(),
        phdAwarded.isNotBlank(),
        meGuide.isNotBlank(),
        phdGuided.isNotBlank(),
        conductedCount.isNotBlank(),
        attendedCount.isNotBlank()
    )
}

@Preview(showBackground = true)
@Composable
fun AcademicScreenFormPreview() {
    AcademicScreenForm(
        true, rememberNavController(), "", "", "", "", "",
        {}, {}, {}, {}, {}, {}, "", ""
    )
}