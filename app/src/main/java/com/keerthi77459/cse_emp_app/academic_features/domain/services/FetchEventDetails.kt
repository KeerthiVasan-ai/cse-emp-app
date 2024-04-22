package com.keerthi77459.cse_emp_app.academic_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AttendedData
import com.keerthi77459.cse_emp_app.academic_features.data.repository.ConductedData
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth

class FetchEventDetails {

    fun fetchAttendedDetails(
        onSuccess: (List<AttendedData>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val db = FirebaseFirestore.getInstance()
        val auth = Auth().auth.uid

        db.collection("academic_detail").document(auth.toString())
            .collection("attended")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null) {
                        val dataList = mutableListOf<AttendedData>()
                        for (document in queryDocumentSnapshots.documents) {
                            val data = document.data
                            data?.let {
                                dataList.add(
                                    AttendedData(
                                        event = data["event"].toString(),
                                        year = data["year"].toString(),
                                        name = data["name"].toString(),
                                        conductedBy = data["conductedBy"].toString(),
                                        startDate = data["startDate"].toString(),
                                        endDate = data["endDate"].toString()
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

    fun fetchConductedDetails(
        onSuccess: (List<ConductedData>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val db = FirebaseFirestore.getInstance()
        val auth = Auth().auth.uid

        db.collection("academic_detail").document(auth.toString())
            .collection("conducted")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null) {
                        val dataList = mutableListOf<ConductedData>()
                        for (document in queryDocumentSnapshots.documents) {
                            val data = document.data
                            data?.let {
                                dataList.add(
                                    ConductedData(
                                        event = data["event"].toString(),
                                        year = data["year"].toString(),
                                        name = data["name"].toString(),
                                        startDate = data["startDate"].toString(),
                                        endDate = data["endDate"].toString()
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