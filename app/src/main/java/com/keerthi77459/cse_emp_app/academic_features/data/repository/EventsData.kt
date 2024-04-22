package com.keerthi77459.cse_emp_app.academic_features.data.repository

data class AttendedData(
    var event: String,
    var year: String,
    var name: String,
    var conductedBy: String,
    var startDate: String,
    var endDate: String,
)

data class ConductedData(
    var event: String,
    var year: String,
    var name: String,
    var startDate: String,
    var endDate: String
)