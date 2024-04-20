package com.keerthi77459.cse_emp_app.personal_details_features.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.core.components.BuildButton
import com.keerthi77459.cse_emp_app.core.components.BuildTextField
import com.keerthi77459.cse_emp_app.core.components.buildDatePicker

@Composable
fun PersonalDetailsForm(
    editing: Boolean,

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

    profileImage: Painter,

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
        Image(
            painter = profileImage,
            contentDescription = "Profile Picture",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (editing) {
            BuildTextField(
                value = editedTokenNumber,
                onValueChange = { editedTokenNumber = it },
                readOnly = false,
                label = "Token Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedName,
                onValueChange = { editedName = it },
                readOnly = false,
                label = "Name"
            )
            Spacer(modifier = Modifier.height(8.dp))
            editedDOB = buildDatePicker(date = editedDOB, label = "Date of Birth", isEditing = true)
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedDesignation,
                onValueChange = { editedDesignation = it },
                readOnly = false,
                label = "Designation"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedQualification,
                onValueChange = { editedQualification = it },
                readOnly = false,
                label = "Qualification"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedSpecialization,
                onValueChange = { editedSpecialization = it },
                readOnly = false,
                label = "Specialization"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedAddress,
                onValueChange = { editedAddress = it },
                readOnly = false,
                label = "Permanent Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedPresentAddress,
                onValueChange = { editedPresentAddress = it },
                readOnly = false,
                label = "Present Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedPhoneNumber,
                onValueChange = { editedPhoneNumber = it },
                readOnly = false,
                label = "Phone Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = editedBloodGroup,
                onValueChange = { editedBloodGroup = it },
                readOnly = false,
                label = "Blood Group"
            )

            BuildButton {
                if (editing) {
                    onTokenNumberChange(editedTokenNumber)
                    onNameChange(editedName)
                    onDOBChange(dob)
                    onDesignationChange(editedDesignation)
                    onQualificationChange(editedQualification)
                    onSpecializationChange(editedSpecialization)
                    onAddressChange(editedAddress)
                    onPresentAddressChange(editedPresentAddress)
                    onPhoneNumberChange(editedPhoneNumber)
                    onBloodGroupChange(editedBloodGroup)
                }
                onEditingChange(!editing)

            }
        } else {
            BuildTextField(
                value = tokenNumber,
                onValueChange = {},
                readOnly = true,
                label = "Token Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = name,
                onValueChange = {},
                readOnly = true,
                label = "Name"
            )
            Spacer(modifier = Modifier.height(8.dp))
            buildDatePicker(date = dob, label = "Date of Birth", isEditing = false)
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = designation,
                onValueChange = {},
                readOnly = true,
                label = "Designation"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = qualification,
                onValueChange = {},
                readOnly = true,
                label = "Qualification"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = specialization,
                onValueChange = {},
                readOnly = true,
                label = "Specialization"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = address,
                onValueChange = {},
                readOnly = true,
                label = "Permanent Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = presentAddress,
                onValueChange = {},
                readOnly = true,
                label = "Present Address"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = phoneNumber,
                onValueChange = {},
                readOnly = true,
                label = "Phone Number"
            )
            Spacer(modifier = Modifier.height(8.dp))
            BuildTextField(
                value = bloodGroup,
                onValueChange = {},
                readOnly = true,
                label = "Blood Group"
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}