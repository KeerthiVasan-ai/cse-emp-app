package com.keerthi77459.cse_emp_app.core.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import java.util.Calendar

@Composable
fun buildDatePicker(
    date: String,
    label: String,
    isEditing: Boolean,
    showError: Boolean,
    errorMessage: String = "Required Field"
): String {
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val selectedDate = remember { mutableStateOf(TextFieldValue(date)) }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val formattedDate = "$dayOfMonth-${month + 1}-$year"
            selectedDate.value = TextFieldValue(formattedDate)
        },
        mCalendar.get(Calendar.YEAR),
        mCalendar.get(Calendar.MONTH),
        mCalendar.get(Calendar.DAY_OF_MONTH)
    )

    Column {
        OutlinedTextField(
            value = selectedDate.value,
            onValueChange = { selectedDate.value = it },
            readOnly = true,
            isError = showError,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(label) },
            trailingIcon = {
                if (isEditing) {
                    Icon(
                        Icons.Outlined.DateRange, "contentDescription",
                        Modifier.clickable { mDatePickerDialog.show() })
                }
            }
        )
        if (showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .offset(y = (8).dp)
                    .fillMaxWidth(0.9f)
            )
        }
    }
    return selectedDate.value.text
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    buildDatePicker("21-01-2023", "Date", isEditing = false, showError = true)
}
