package com.keerthi77459.cse_emp_app.online_courses_feature.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.online_courses_feature.data.OnlineCoursesData

class FetchOnlineCourseDetails {
    fun fetchDetails(onSuccess: (List<OnlineCoursesData>) -> Unit, onFailure: (Exception) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid
        db.collection("online_courses")
            .document(uid.toString())
            .collection("courses")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null) {
                        val dataList = mutableListOf<OnlineCoursesData>()
                        for (document in queryDocumentSnapshots.documents) {
                            val data = document.data
                            data?.let {
                                dataList.add(
                                    OnlineCoursesData(
                                        course = data["course"].toString(),
                                        offeredBy = data["offeredBy"].toString(),
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

