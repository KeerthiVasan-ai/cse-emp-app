package com.keerthi77459.cse_emp_app.publication_features.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ConferenceData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.JournalData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.PatentData

@Composable
fun JournalDetailsView(journalData: JournalData) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 0.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Column(
            modifier = Modifier
                .clickable {}
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = journalData.authorName, style = Styles().mediumText2)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = journalData.journalName, style = Styles().mediumText2)
        }
    }
}

@Composable
fun ConferenceDetailsView(conferenceData: ConferenceData) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 0.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Column(
            modifier = Modifier
                .clickable {}
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = conferenceData.authorName, style = Styles().mediumText2)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = conferenceData.conferenceName, style = Styles().mediumText2)
        }
    }
}

@Composable
fun PatentDetailsView(patentData: PatentData) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 0.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Column(
            modifier = Modifier
                .clickable {}
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = patentData.patentTitle, style = Styles().mediumText2)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = patentData.status, style = Styles().mediumText2)
        }
    }
}