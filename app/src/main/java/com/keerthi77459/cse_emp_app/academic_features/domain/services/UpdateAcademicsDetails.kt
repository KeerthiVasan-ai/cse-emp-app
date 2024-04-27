package com.keerthi77459.cse_emp_app.academic_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AcademicData
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth

class UpdateAcademicsDetails {
    fun updateAcademicsDetails(academicData: AcademicData) {
        val db = FirebaseFirestore.getInstance()
        val auth = Auth().auth.uid

        db.collection("academic_details").document(auth.toString())
            .set(academicData)
            .addOnSuccessListener {
                println("SUCCESS")
            }.addOnFailureListener {
                println(it.message.toString())
            }

    }
}