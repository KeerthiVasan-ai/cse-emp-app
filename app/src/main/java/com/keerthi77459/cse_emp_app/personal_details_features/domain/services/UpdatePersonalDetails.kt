package com.keerthi77459.cse_emp_app.personal_details_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.personal_details_features.data.PersonalDetailsData

class UpdatePersonalDetails {
    fun updatePersonalDetails(personalDetailsData: PersonalDetailsData){
        val db = FirebaseFirestore.getInstance()
        val auth = Auth().auth.uid

        db.collection("personal_details").document(auth.toString())
            .set(personalDetailsData)
            .addOnSuccessListener {
                println("SUCCESS")
            }.addOnFailureListener{
                println(it.message.toString())
            }

    }
}