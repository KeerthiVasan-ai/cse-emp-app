package com.keerthi77459.cse_emp_app.publication_features.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

    var conferenceType by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var conferenceName by remember { mutableStateOf("") }
    var conducted by remember { mutableStateOf("") }
    var conferenceDate by remember { mutableStateOf("") }
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
            menus = listOf("National", "International")
        )
        Spacer(modifier = Modifier.height(8.dp))
        year = buildDropDownMenu(
            label = "Year",
            menus = listOf("2021-2022", "2022-2023", "2023-2024", "2024-2025")
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = authorName,
            onValueChange = { authorName = it },
            readOnly = false,
            label = "Author Name"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = title,
            onValueChange = { title = it },
            readOnly = false,
            label = "Title of the Paper"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = conferenceName,
            onValueChange = { conferenceName = it },
            readOnly = false,
            label = "Conference Name"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = conducted,
            onValueChange = { conducted = it },
            readOnly = false,
            label = "Conference Conducted By"
        )
        Spacer(modifier = Modifier.height(8.dp))
        conferenceDate = buildDatePicker(
            date = conferenceDate,
            label = "Conference Date",
            isEditing = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = proceedingName,
            onValueChange = { proceedingName = it },
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
            InsertConferenceDetails(context).insertConferenceDetails(
                ConferenceData(
                    authorName,
                    title,
                    conferenceName,
                    conducted,
                    conferenceDate,
                    proceedingName,
                    issnNo
                )
            )
            navController.navigate(NavigationScreen.MainScreen.route)
        }
    }
}