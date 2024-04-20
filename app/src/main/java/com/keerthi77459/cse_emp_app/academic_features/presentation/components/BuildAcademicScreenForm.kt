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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.core.components.BuildTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AcademicScreenForm(
    joiningDate: String,
    meAwarded: String,
    phdAwarded: String,
    meGuide: String,
    phdGuided: String,

    seminarConducted: String,
    workshopConducted: String,
    fdpConducted: String,
    sttpConducted: String,

    seminarAttended: String,
    workshopAttended: String,
    fdpAttended: String,
    sttpAttended: String
) {


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
    ) {
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
            value = seminarConducted,
            onValueChange = {},
            readOnly = true,
            label = "Seminars Conducted"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = workshopConducted,
            onValueChange = {},
            readOnly = true,
            label = "Workshops Conducted"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = fdpConducted,
            onValueChange = {},
            readOnly = true,
            label = "FDP Conducted"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = sttpConducted,
            onValueChange = {},
            readOnly = true,
            label = "STTP Conducted"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = seminarAttended,
            onValueChange = {},
            readOnly = true,
            label = "Seminars Attended"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = workshopAttended,
            onValueChange = {},
            readOnly = true,
            label = "Workshops Attended"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = fdpAttended,
            onValueChange = {},
            readOnly = true,
            label = "FDP Attended"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = sttpAttended,
            onValueChange = {},
            readOnly = true,
            label = "STTP Attended"
        )
        Spacer(modifier = Modifier.height(8.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun AcademicScreenFormPreview() {
    AcademicScreenForm(
        "", "", "", "", "",
        "", "", "", "", "", "", "",
        ""
    )
}