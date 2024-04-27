package com.keerthi77459.cse_emp_app.personal_details_features.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker
import com.keerthi77459.cse_emp_app.core.navigation.NavigationScreen
import com.keerthi77459.cse_emp_app.personal_details_features.data.PersonalDetailsData
import com.keerthi77459.cse_emp_app.personal_details_features.domain.services.UpdatePersonalDetails

@Composable
fun PersonalDetailsForm(
    editing: Boolean,
    navController: NavController,

    tokenNumber: String,
    name: String,
    dob: String,
    designation: String,
    qualification: String,
    specialization: String,
    bloodGroup: String,
    phoneNumber: String,
    address: String,
    presentAddress: String,

    onTokenNumberChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onDOBChange: (String) -> Unit,
    onDesignationChange: (String) -> Unit,
    onQualificationChange: (String) -> Unit,
    onSpecializationChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onAddressChange: (String) -> Unit,
    onPresentAddressChange: (String) -> Unit,
    onBloodGroupChange: (String) -> Unit,

    onEditingChange: (Boolean) -> Unit
) {

    var validateDetails by remember {
        mutableStateOf(
            listOf(
                true, true, true,
                true, true, true,
                true, true, true,
                true
            )
        )
    }
    var editedTokenNumber by remember { mutableStateOf(tokenNumber) }
    var editedName by remember { mutableStateOf(name) }
    var editedDOB by remember { mutableStateOf(dob) }
    var editedDesignation by remember { mutableStateOf(designation) }
    var editedQualification by remember { mutableStateOf(qualification) }
    var editedSpecialization by remember { mutableStateOf(specialization) }
    var editedAddress by remember { mutableStateOf(address) }
    var editedPresentAddress by remember { mutableStateOf(presentAddress) }
    var editedPhoneNumber by remember { mutableStateOf(phoneNumber) }
    var editedBloodGroup by remember { mutableStateOf(bloodGroup) }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
    ) {
        if (editing) {
            BuildTextField(
                value = editedTokenNumber,
                onValueChange = { editedTokenNumber = it },
                showError = !validateDetails[0],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Staff Id"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedName,
                onValueChange = { editedName = it },
                showError = !validateDetails[1],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Name"
            )
            Spacer(modifier = Modifier.height(8.dp))
            editedDOB = buildDatePicker(
                date = editedDOB,
                label = "Date of Birth",
                isEditing = true,
                showError = !validateDetails[2]
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedDesignation,
                onValueChange = { editedDesignation = it },
                showError = !validateDetails[3],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Designation"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedQualification,
                onValueChange = { editedQualification = it },
                showError = !validateDetails[4],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Qualification"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedSpecialization,
                onValueChange = { editedSpecialization = it },
                showError = !validateDetails[5],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Specialization"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedAddress,
                onValueChange = { editedAddress = it },
                showError = !validateDetails[6],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Permanent Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedPresentAddress,
                onValueChange = { editedPresentAddress = it },
                showError = !validateDetails[7],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Present Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedPhoneNumber,
                onValueChange = { editedPhoneNumber = it },
                showError = !validateDetails[8],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Phone Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedBloodGroup,
                onValueChange = { editedBloodGroup = it },
                showError = !validateDetails[9],
                errorMessage = "Required Field",
                readOnly = false,
                label = "Blood Group"
            )
            Spacer(modifier = Modifier.height(16.dp))
            BuildButton("Update") {
                validateDetails = validate(
                    tokenNumber = editedTokenNumber,
                    name = editedName,
                    designation = editedDesignation,
                    qualification = editedQualification,
                    specialization = editedSpecialization,
                    dob = editedDOB,
                    address = editedAddress,
                    presentAddress = editedPresentAddress,
                    phoneNumber = editedPhoneNumber,
                    bloodGroup = editedBloodGroup
                )
                println(validateDetails)
                val isValidated = validateDetails.all { it }
                println(isValidated)
                if (isValidated) {

                    UpdatePersonalDetails().updatePersonalDetails(
                        PersonalDetailsData(
                            tokenNumber = editedTokenNumber,
                            name = editedName,
                            dob = editedDOB,
                            designation = editedDesignation,
                            qualification = editedQualification,
                            specialization = editedSpecialization,
                            address = editedAddress,
                            presentAddress = editedPresentAddress,
                            phoneNumber = editedPhoneNumber,
                            bloodGroup = editedBloodGroup
                        )
                    )
                    onTokenNumberChange(editedTokenNumber)
                    onNameChange(editedName)
                    onDOBChange(editedDOB)
                    onDesignationChange(editedDesignation)
                    onQualificationChange(editedQualification)
                    onSpecializationChange(editedSpecialization)
                    onAddressChange(editedAddress)
                    onPresentAddressChange(editedPresentAddress)
                    onPhoneNumberChange(editedPhoneNumber)
                    onBloodGroupChange(editedBloodGroup)

                    onEditingChange(!editing)
                    navController.navigate(NavigationScreen.PersonalDetailsScreen.route) {
                        popUpTo(NavigationScreen.PersonalDetailsScreen.route) {
                            inclusive = true
                        }
                    }
                }
            }
        } else {
            BuildTextField(
                value = tokenNumber,
                onValueChange = {},
                showError = !validateDetails[0],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Staff Id"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = name,
                onValueChange = {},
                showError = !validateDetails[1],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Name"
            )
            Spacer(modifier = Modifier.height(8.dp))
            buildDatePicker(
                date = dob,
                label = "Date of Birth",
                isEditing = false,
                showError = !validateDetails[2]
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = designation,
                onValueChange = {},
                showError = !validateDetails[3],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Designation"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = qualification,
                onValueChange = {},
                showError = !validateDetails[4],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Qualification"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = specialization,
                onValueChange = {},
                showError = !validateDetails[5],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Specialization"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = address,
                onValueChange = {},
                showError = !validateDetails[6],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Permanent Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = presentAddress,
                onValueChange = {},
                showError = !validateDetails[7],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Present Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = phoneNumber,
                onValueChange = {},
                showError = !validateDetails[8],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Phone Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = bloodGroup,
                onValueChange = {},
                showError = !validateDetails[9],
                errorMessage = "Required Field",
                readOnly = true,
                label = "Blood Group"
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

fun validate(
    tokenNumber: String,
    name: String,
    designation: String,
    qualification: String,
    specialization: String,
    dob: String,
    address: String,
    presentAddress: String,
    phoneNumber: String,
    bloodGroup: String
): List<Boolean> {
    return listOf(
        tokenNumber.isNotBlank(),
        name.isNotBlank(),
        designation.isNotBlank(),
        qualification.isNotBlank(),
        specialization.isNotBlank(),
        dob.isNotBlank(),
        address.isNotBlank(),
        presentAddress.isNotBlank(),
        phoneNumber.isNotBlank(),
        bloodGroup.isNotBlank()
    )
}