package com.keerthi77459.cse_emp_app.recognition_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.recognition_features.data.repository.RecognitionData

class FetchRecognitionDetails {
    fun fetchDetails(onSuccess: (List<RecognitionData>) -> Unit, onFailure: (Exception) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid
        db.collection("recognition_details")
            .document(uid.toString())
            .collection("awards")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null) {
                        val dataList = mutableListOf<RecognitionData>()
                        for (document in queryDocumentSnapshots.documents) {
                            val data = document.data
                            data?.let {
                                dataList.add(
                                    RecognitionData(
                                        name = data["name"].toString(),
                                        givenBy = data["givenBy"].toString(),
                                        date = data["date"].toString(),
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