package com.keerthi77459.cse_emp_app.recognition_features.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker
import com.keerthi77459.cse_emp_app.recognition_features.data.repository.RecognitionData
import com.keerthi77459.cse_emp_app.recognition_features.domain.services.InsertRecognitionDetails

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun RecognitionScreen() {

    var name by remember { mutableStateOf("") }
    var givenBy by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            BuildAppBar(
                title = "Recognition Details Form",
                icon = R.drawable.baseline_edit_note_24
            ) {}
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Furnish the below Details")
                    Spacer(modifier = Modifier.height(16.dp))
                    BuildTextField(
                        value = name,
                        onValueChange = { name = it },
                        readOnly = false,
                        label = "Name of the Award"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    BuildTextField(
                        value = givenBy,
                        onValueChange = { givenBy = it },
                        readOnly = false,
                        label = "Given By"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    date = buildDatePicker(date = date, label = "Date", isEditing = true)
                    Spacer(modifier = Modifier.height(8.dp))
                    BuildButton {
                        InsertRecognitionDetails().insertRecognitionDetails(
                            RecognitionData(
                                name,
                                givenBy,
                                date
                            )
                        )
                    }
                }
            }
        }
    }
}