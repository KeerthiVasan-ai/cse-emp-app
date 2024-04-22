package com.keerthi77459.cse_emp_app.recognition_features.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildFloatingActionButton
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.recognition_features.data.repository.RecognitionData
import com.keerthi77459.cse_emp_app.recognition_features.domain.services.FetchRecognitionDetails
import com.keerthi77459.cse_emp_app.recognition_features.presentation.components.BuildListView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecognitionView(navController: NavController) {

    var recognitionDetails by remember { mutableStateOf<List<RecognitionData>>(listOf()) }

    LaunchedEffect(Unit) {
        FetchRecognitionDetails().fetchDetails(
            onSuccess = { data ->
                recognitionDetails = data
            }, onFailure = {
                println(it.message)
            }
        )
    }

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Recognition",
                showIcon = false,
                icon = Icons.Filled.Add
            ) {}
        },
        floatingActionButton = {
            BuildFloatingActionButton(icon = Icons.Filled.Add) {
                navController.navigate(NavigationScreen.RecognitionScreen.route)
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            LazyColumn {
                itemsIndexed(recognitionDetails) { _, data ->
                    BuildListView(recognitionData = data)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecognitionScreen() {
    RecognitionView(navController = rememberNavController())
}