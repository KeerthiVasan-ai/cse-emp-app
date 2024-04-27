package com.keerthi77459.cse_emp_app.publication_features.data.repository

data class JournalData(
    var authorName: String,
    var journalName: String,
    var volNo: String,
    var issueNo: String,
    var indexed: String,
    var issnNo: String,
    var impactFactor: String
)

data class ConferenceData(
    var authorName: String,
    var paperTitle: String,
    var conferenceName: String,
    var conducted: String,
    var startDate: String,
    var endDate: String,
    var proceedingName: String,
    var issnNo: String = ""
)

data class PatentData(
    var fileNo: String,
    var patentTitle: String,
    var date: String,
    var status: String
)