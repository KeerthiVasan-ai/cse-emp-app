package com.keerthi77459.cse_emp_app.publication_features.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.buildDropDownMenu
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.publication_features.presentation.components.ConferenceScreen
import com.keerthi77459.cse_emp_app.publication_features.presentation.components.JournalScreen
import com.keerthi77459.cse_emp_app.publication_features.presentation.components.PatentScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PublicationScreen(navController: NavController, context: Context) {

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Publication Details Form",
                showIcon = false,
                icon = Icons.Filled.Add
            ) {}
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Styles().background)
                .padding(paddingValues = paddingValue),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InitUI(navController, context)
        }
    }
}

@Composable
fun InitUI(navController: NavController, context: Context) {

    var publicationType by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        publicationType = buildDropDownMenu(
            label = "Publication Type",
            menus = listOf("Journal", "Conference", "Patent")
        )
        when (publicationType) {
            "Journal" -> JournalScreen(navController = navController, context = context)
            "Conference" -> ConferenceScreen(navController = navController, context = context)
            "Patent" -> PatentScreen(navController = navController, context = context)
        }
    }
}