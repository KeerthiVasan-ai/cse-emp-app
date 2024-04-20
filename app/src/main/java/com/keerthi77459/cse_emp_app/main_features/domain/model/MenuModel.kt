package com.keerthi77459.cse_emp_app.main_features.domain.model

import com.keerthi77459.cse_emp_app.R
import com.keerthi77459.cse_emp_app.main_features.data.repository.MenuData

object MenuModel {
    val menuList = listOf(
        MenuData(
            title = "Personal Details",
            image = R.drawable.logo
        ),
        MenuData(
            title = "Academics",
            image = R.drawable.logo
        ),
        MenuData(
            title = "Publications",
            image = R.drawable.logo
        ),
        MenuData(
            title = "Recognition",
            image = R.drawable.logo
        ),
        MenuData(
            title = "Online Courses",
            image = R.drawable.logo
        )
    )
}