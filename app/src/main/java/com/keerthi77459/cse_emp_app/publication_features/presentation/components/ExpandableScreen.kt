package com.keerthi77459.cse_emp_app.publication_features.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ConferenceData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ExpandableState
import com.keerthi77459.cse_emp_app.publication_features.data.repository.JournalData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.PatentData

@Composable
fun ExpandableScreen(state: ExpandableState) {
    val isExpandList = remember {
        mutableStateListOf<Boolean>().apply {
            addAll(List(state.data.keys.size) { false })
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            state.data.onEachIndexed { index, entry ->
                val isExpand = isExpandList[index]
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                isExpandList[index] = !isExpand
                            }
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = entry.key,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            imageVector = if (isExpand) Icons.Default.ArrowDropDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = "expand icon"
                        )


                    }
                }

                if (isExpand) {
                    items(entry.value) {
                        AnimatedVisibility(
                            visible = true,
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                            ) {
                                Text(
                                    text = when (it) {
                                        is JournalData -> it.journalName
                                        is ConferenceData -> it.conferenceName
                                        is PatentData -> it.patentTitle
                                        else -> ""
                                    },
                                    style = TextStyle(fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ExpandableListPreview() {
    ExpandableScreen(
        state = ExpandableState(listOf(), listOf(), listOf())
    )
}