package com.keerthi77459.cse_emp_app.publication_features.presentation.components

import android.content.Context
import android.widget.Toast
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
import com.keerthi77459.cse_emp_app.publication_features.data.repository.PatentData
import com.keerthi77459.cse_emp_app.publication_features.domain.services.InsertPatentDetails

@Composable
fun PatentScreen(navController: NavController, context: Context) {
    var fileNo by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BuildTextField(
            value = fileNo,
            onValueChange = { fileNo = it },
            readOnly = false,
            label = "Patent's File No"
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildTextField(
            value = title,
            onValueChange = { title = it },
            readOnly = false,
            label = "Title of the Work"
        )
        Spacer(modifier = Modifier.height(8.dp))
        date = buildDatePicker(date = date, label = "Date of Application", isEditing = true)
        Spacer(modifier = Modifier.height(8.dp))
        status = buildDropDownMenu(
            label = "Status",
            menus = listOf("Approved", "Waiting", "Rejected")
        )
        Spacer(modifier = Modifier.height(8.dp))
        BuildButton {
            InsertPatentDetails(context).insertPatentDetails(
                PatentData(
                    fileNo,
                    title,
                    date,
                    status
                )
            )
            navController.navigate(NavigationScreen.MainScreen.route)
        }
    }
}