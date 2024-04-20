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
import com.keerthi77459.cse_emp_app.core.components.buildDropDownMenu
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.publication_features.data.repository.JournalData
import com.keerthi77459.cse_emp_app.publication_features.domain.services.InsertJournalDetails

@Composable
fun JournalScreen(navController: NavController, context: Context) {

    var journalType by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }
    var journalName by remember { mutableStateOf("") }
    var volNo by remember { mutableStateOf("") }
    var issueNo by remember { mutableStateOf("") }
    var indexed by remember { mutableStateOf("") }
    var issnNo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        journalType = buildDropDownMenu(
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
            onValueChange = { newValue -> authorName = newValue },
            readOnly = false,
            label = "Author Name"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = journalName,
            onValueChange = { newValue -> journalName = newValue },
            readOnly = false,
            label = "Journal Name"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = volNo,
            onValueChange = { newValue -> volNo = newValue },
            readOnly = false,
            label = "Volume Number"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = issueNo,
            onValueChange = { newValue -> issueNo = newValue },
            readOnly = false,
            label = "Issue Number"
        )
        Spacer(modifier = Modifier.height(8.dp))
        indexed = buildDropDownMenu(
            label = "Indexed",
            menus = listOf("IEEE", "SCOPUS", "SCI", "UGC CARE", "WOS", "Others")
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = issnNo,
            onValueChange = { newValue -> issnNo = newValue },
            readOnly = false,
            label = "ISSN Number"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildButton {
            InsertJournalDetails(context).insertJournalDetails(
                JournalData(
                    authorName,
                    journalName,
                    volNo,
                    issueNo,
                    indexed, issnNo
                )
            )
            navController.navigate(NavigationScreen.MainScreen.route)
        }
    }
}