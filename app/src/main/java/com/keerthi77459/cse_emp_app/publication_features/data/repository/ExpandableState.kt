package com.keerthi77459.cse_emp_app.publication_features.data.repository

data class ExpandableState (
    val journalList: List<JournalData>,
    val conferenceList: List<ConferenceData>,
    val patentList: List<PatentData>
){


    val data: Map<String, List<Any>> = mapOf(
        "Patent" to patentList,
        "Conference" to conferenceList,
        "Journal" to journalList
    )
}
