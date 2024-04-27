package com.keerthi77459.cse_emp_app.main_features.domain.model

import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.main_features.data.repository.MenuData

object MenuModel {
    val menuList = listOf(
        MenuData(
            title = "Personal Details",
            image = R.drawable.personal
        ),
        MenuData(
            title = "Academics",
            image = R.drawable.academics
        ),
        MenuData(
            title = "Publications",
            image = R.drawable.publication
        ),
        MenuData(
            title = "Recognition",
            image = R.drawable.recognition
        ),
        MenuData(
            title = "Online Courses",
            image = R.drawable.online_courses
        )
    )
}