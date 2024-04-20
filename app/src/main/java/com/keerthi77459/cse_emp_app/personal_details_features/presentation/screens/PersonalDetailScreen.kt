package com.keerthi77459.cse_emp_app.personal_details_features.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.core.components.BuildAppBar
import com.keerthi77459.cse_emp_app.personal_details_features.data.PersonalDetailsData
import com.keerthi77459.cse_emp_app.personal_details_features.domain.services.FetchPersonalDetails
import com.keerthi77459.cse_emp_app.personal_details_features.presentation.components.PersonalDetailsForm

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PersonalDetailsScreen() {

    var personalDetails by remember { mutableStateOf<PersonalDetailsData?>(null) }
    var editing by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        FetchPersonalDetails().fetchDetails(
            onSuccess = { data ->
                personalDetails = data
            }, onFailure = { _ ->

            }
        )
    }

    println(personalDetails?.name)

    var tokenNumber by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var designation by remember { mutableStateOf("") }
    var qualification by remember { mutableStateOf("") }
    var specialization by remember { mutableStateOf("") }
    var bloodGroup by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var presentAddress by remember { mutableStateOf("") }
    val profileImage: Painter = painterResource(id = R.drawable.logo)

    Scaffold(topBar = {
        BuildAppBar(title = "Personal Details", R.drawable.baseline_edit_note_24) {
            editing = !editing
        }
    }) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValues = paddingValue),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            personalDetails?.let { data ->
                PersonalDetailsForm(

                    editing = editing,

                    tokenNumber = data.tokenNumber,
                    name = data.name,
                    dob = data.dob,
                    designation = data.designation,
                    qualification = data.qualification,
                    specialization = data.specialization,
                    bloodGroup = data.bloodGroup,
                    phoneNumber = data.phoneNumber,
                    address = data.address,
                    presentAddress = data.presentAddress,

                    profileImage = profileImage,

                    onTokenNumberChange = { tokenNumber = it },
                    onNameChange = { name = it },
                    onDOBChange = { dob = it },
                    onDesignationChange = { designation = it },
                    onQualificationChange = { qualification = it },
                    onSpecializationChange = { specialization = it },
                    onAddressChange = { address = it },
                    onBloodGroupChange = { bloodGroup = it },
                    onPhoneNumberChange = { phoneNumber = it },
                    onPresentAddressChange = { presentAddress = it },

                    onEditingChange = { editing = it }
                )
            }
        }

    }
}