package com.keerthi77459.cse_emp_app.academic_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AcademicData
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth

class FetchAcademicsDetail {
    fun fetchDetails(onSuccess: (AcademicData) -> Unit, onFailure: (Exception) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid
        val reference = db.collection("academic_details").document(uid.toString())
        reference.get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null && queryDocumentSnapshots.exists()) {
                        val data = queryDocumentSnapshots.data
                        val joiningDate = data?.get("joiningDate").toString()
                        val mPhilAward = data?.get("meAwarded").toString()
                        val mPhilGuide = data?.get("meGuide").toString()
                        val phdAwarded = data?.get("phdAwarded").toString()
                        val phdGuide = data?.get("phdGuided").toString()
                        val attendCount = data?.get("attendedCount").toString()
                        val conductedCount = data?.get("conductedCount").toString()


                        val academicData = AcademicData(
                            joiningDate = joiningDate,
                            mPhilAwarded = mPhilAward,
                            mPhilGuide = phdAwarded,
                            phdAwarded = mPhilGuide,
                            phdGuide = phdGuide,
                            attendedCount = attendCount,
                            conductedCount = conductedCount
                        )
                        onSuccess(academicData)
                    } else {
                        onFailure(Exception("Document does not exist"))
                    }
                } else {
                    onFailure(task.exception ?: Exception("Unknown exception"))
                }
            }
    }
}
