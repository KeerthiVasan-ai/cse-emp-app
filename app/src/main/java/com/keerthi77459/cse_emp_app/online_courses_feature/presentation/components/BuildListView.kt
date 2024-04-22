package com.keerthi77459.cse_emp_app.online_courses_feature.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keerthi77459.cse_emp_app.core.styles.Styles
import com.keerthi77459.cse_emp_app.online_courses_feature.data.OnlineCoursesData

@Composable
fun BuildListView(onlineCoursesData: OnlineCoursesData) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Row(Modifier.clickable {}) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = onlineCoursesData.course, style = Styles().mediumText2)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = onlineCoursesData.offeredBy, style = Styles().mediumText2)
            }
        }
    }
}

@Preview
@Composable
fun ListViewPreview() {
    BuildListView(
        onlineCoursesData = OnlineCoursesData(
            course = "Data Analytics with Python",
            offeredBy = "IIT Madras",
            startDate = "01-01-2024",
            endDate = "21-04-2024"
        )
    )
}