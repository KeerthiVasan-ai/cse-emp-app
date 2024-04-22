package com.keerthi77459.cse_emp_app.main_features.presentation.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keerthi77459.cse_emp_app.main_features.data.repository.MenuData

@Composable
fun BuildGridItems(data: MenuData, navController: NavController, context: Context) {

    Column(
        Modifier
            .height(200.dp)
            .width(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(180.dp)
                .clip(RoundedCornerShape(30.dp))
                .clickable {
                    println(data.title)
                    try {
                        navController.navigate(data.title)
                    } catch (_: Exception) {
                        Toast
                            .makeText(context, "Under Construction", Toast.LENGTH_LONG)
                            .show()
                    }
                },
            painter = painterResource(id = data.image),
            contentDescription = data.title,
            contentScale = ContentScale.Crop
        )
        Text(
            text = data.title,
            fontWeight = FontWeight.SemiBold
        )
    }
}