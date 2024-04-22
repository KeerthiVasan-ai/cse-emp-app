package com.keerthi77459.cse_emp_app.publication_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ConferenceData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.JournalData
import com.keerthi77459.cse_emp_app.publication_features.data.repository.PatentData

class FetchPublicationDetails {
    fun fetchJournalDetails(
        onSuccess: (List<JournalData>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid
        val reference =
            db.collection("publication_details").document(uid.toString()).collection("journals")
                .document("journals_details")
        reference.collection("details")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null) {
                        val dataList = mutableListOf<JournalData>()
                        for (document in queryDocumentSnapshots.documents) {
                            val data = document.data
                            data?.let {
                                dataList.add(
                                    JournalData(
                                        authorName = data["authorName"].toString(),
                                        journalName = data["journalName"].toString(),
                                        volNo = data["volNo"].toString(),
                                        indexed = data["indexed"].toString(),
                                        issueNo = data["issueNo"].toString(),
                                        issnNo = data["issnNo"].toString()
                                    )
                                )
                            }
                        }
                        onSuccess(dataList)
                    } else {
                        onFailure(Exception("Document does not exist"))
                    }
                } else {
                    onFailure(task.exception ?: Exception("Unknown exception"))
                }
            }
    }

    fun fetchConferenceDetails(
        onSuccess: (List<ConferenceData>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid
        val reference =
            db.collection("publication_details").document(uid.toString()).collection("conferences")
                .document("conferences_details")
        reference.collection("details")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null) {
                        val dataList = mutableListOf<ConferenceData>()
                        for (document in queryDocumentSnapshots.documents) {
                            val data = document.data
                            data?.let {
                                dataList.add(
                                    ConferenceData(
                                        authorName = data["authorName"].toString(),
                                        paperTitle = data["paperTitle"].toString(),
                                        conferenceName = data["conferenceName"].toString(),
                                        conducted = data["conducted"].toString(),
                                        startDate = data["startDate"].toString(),
                                        endDate = data["endDate"].toString(),
                                        proceedingName = data["proceedingName"].toString(),
                                        issnNo = data["issnNo"].toString()
                                    )
                                )
                            }
                        }
                        onSuccess(dataList)
                    } else {
                        onFailure(Exception("Document does not exist"))
                    }
                } else {
                    onFailure(task.exception ?: Exception("Unknown exception"))
                }
            }
    }

    fun fetchPatentDetails(
        onSuccess: (List<PatentData>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid
        val reference =
            db.collection("publication_details").document(uid.toString()).collection("patents")
                .document("patents_details")
        reference.collection("details")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null) {
                        val dataList = mutableListOf<PatentData>()
                        for (document in queryDocumentSnapshots.documents) {
                            val data = document.data
                            data?.let {
                                dataList.add(
                                    PatentData(
                                        fileNo = data["fileNo"].toString(),
                                        patentTitle = data["patentTitle"].toString(),
                                        date = data["date"].toString(),
                                        status = data["status"].toString()
                                    )
                                )
                            }
                        }
                        onSuccess(dataList)
                    } else {
                        onFailure(Exception("Document does not exist"))
                    }
                } else {
                    onFailure(task.exception ?: Exception("Unknown exception"))
                }
            }
    }
}