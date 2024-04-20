package com.keerthi77459.cse_emp_app.recognition_features.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildFloatingActionButton
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.recognition_features.data.repository.RecognitionData
import com.keerthi77459.cse_emp_app.recognition_features.domain.services.FetchRecognitionDetails

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
        topBar = { BuildAppBar(title = "Recognition", icon = R.drawable.baseline_edit_note_24) {} },
        floatingActionButton = {
            BuildFloatingActionButton(icon = Icons.Filled.Add) {
                navController.navigate(NavigationScreen.RecognitionScreen.route)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            itemsIndexed(recognitionDetails) { _, data ->
                Text(text = data.name)
            }
        }
    }
}