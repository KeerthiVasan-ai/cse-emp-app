package com.keerthi77459.cse_emp_app.publication_features.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildFloatingActionButton
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ConferenceData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ExpandableState
import com.keerthi77459.cse_emp_app.publication_features.data.repository.JournalData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.PatentData
import com.keerthi77459.cse_emp_app.publication_features.domain.services.FetchPublicationDetails
import com.keerthi77459.cse_emp_app.publication_features.presentation.components.ExpandableScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PublicationView(navController: NavController) {

    var journalDetails by remember { mutableStateOf<List<JournalData>>(listOf()) }
    var conferenceDetails by remember { mutableStateOf<List<ConferenceData>>(listOf()) }
    var patentDetails by remember { mutableStateOf<List<PatentData>>(listOf()) }

    LaunchedEffect(Unit) {
        FetchPublicationDetails().fetchJournalDetails(
            onSuccess = { journalDetails = it },
            onFailure = {}
        )
        FetchPublicationDetails().fetchConferenceDetails(
            onSuccess = { conferenceDetails = it },
            onFailure = {}
        )
        FetchPublicationDetails().fetchPatentDetails(
            onSuccess = { patentDetails = it },
            onFailure = {}
        )
    }

    println(journalDetails.size)
    println(conferenceDetails.size)
    println(patentDetails.size)

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Publications",
                showIcon = false,
                icon = Icons.Filled.Add
            ) {}
        },
        floatingActionButton = {
            BuildFloatingActionButton(icon = Icons.Outlined.Add) {
                navController.navigate(NavigationScreen.PublicationScreen.route)
            }
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .background(brush = Styles().background)
                .padding(paddingValues = paddingValue),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            println(patentDetails.size)
            ExpandableScreen(
                state = ExpandableState(
                    journalDetails,
                    conferenceDetails,
                    patentDetails
                )
            )
        }
    }
}
