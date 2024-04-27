package com.keerthi77459.cse_emp_app.publication_features.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker
import com.keerthi77459.cse_emp_app.core.components.buildDropDownMenu
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ConferenceData
import com.keerthi77459.cse_emp_app.publication_features.domain.services.InsertConferenceDetails

@Composable
fun ConferenceScreen(navController: NavController, context: Context) {

    var validateDetails by remember {
        mutableStateOf(
            listOf(
                true, true, true, true, true,
                true, true, true, true,
            )
        )
    }
    var conferenceType by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var conferenceName by remember { mutableStateOf("") }
    var conducted by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    var proceedingName by remember { mutableStateOf("") }
    var issnNo by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        conferenceType = buildDropDownMenu(
            label = "National / International",
            menus = listOf("National", "International"),
            showError = !validateDetails[0]
        )
        Spacer(modifier = Modifier.height(8.dp))
        year = buildDropDownMenu(
            label = "Year",
            menus = listOf("2021-2022", "2022-2023", "2023-2024", "2024-2025"),
            showError = !validateDetails[1]
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = authorName,
            onValueChange = { authorName = it },
            showError = !validateDetails[2],
            readOnly = false,
            label = "Authors Name"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = title,
            onValueChange = { title = it },
            showError = !validateDetails[3],
            readOnly = false,
            label = "Title of the Paper"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = conferenceName,
            onValueChange = { conferenceName = it },
            showError = !validateDetails[4],
            readOnly = false,
            label = "Conference Name"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = conducted,
            onValueChange = { conducted = it },
            showError = !validateDetails[5],
            readOnly = false,
            label = "Conference Conducted By"
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
                    showError = !validateDetails[6],
                    isEditing = true
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(Modifier.weight(1f)) {
                endDate = buildDatePicker(
                    date = "", label = "End Date",
                    showError = !validateDetails[7],
                    isEditing = true
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = proceedingName,
            onValueChange = { proceedingName = it },
            showError = !validateDetails[8],
            readOnly = false,
            label = "Conference Proceeding Name"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = issnNo,
            onValueChange = { issnNo = it },
            readOnly = false,
            label = "ISSN/ISBN Number"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildButton {
            validateDetails = validateConference(
                conferenceType = conferenceType,
                year = year,
                authorName = authorName,
                title = title,
                conferenceName = conferenceName,
                conducted = conducted,
                startDate = startDate,
                endDate = endDate,
                proceedingName = proceedingName
            )
            val isValidated = validateDetails.all { it }
            if (isValidated) {
                InsertConferenceDetails(context).insertConferenceDetails(
                    ConferenceData(
                        authorName = authorName,
                        paperTitle = title,
                        conferenceName = conferenceName,
                        conducted = conducted,
                        startDate = startDate,
                        endDate = endDate,
                        proceedingName = proceedingName,
                        issnNo = issnNo
                    )
                )
                navController.navigate(NavigationScreen.PublicationView.route) {
                    popUpTo(NavigationScreen.PublicationView.route) {
                        inclusive = true
                    }
                }
            }
        }
    }
}

fun validateConference(
    conferenceType: String,
    year: String,
    authorName: String,
    title: String,
    conferenceName: String,
    conducted: String,
    startDate: String,
    endDate: String,
    proceedingName: String,
): List<Boolean> {
    return listOf(
        conferenceType.isNotBlank(),
        year.isNotBlank(),
        authorName.isNotBlank(),
        title.isNotBlank(),
        conferenceName.isNotBlank(),
        conducted.isNotBlank(),
        startDate.isNotBlank(),
        endDate.isNotBlank(),
        proceedingName.isNotBlank(),
    )
}