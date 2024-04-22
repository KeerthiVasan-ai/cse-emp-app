package com.keerthi77459.cse_emp_app.personal_details_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.personal_details_features.data.PersonalDetailsData

class FetchPersonalDetails {
    fun fetchDetails(onSuccess: (PersonalDetailsData) -> Unit, onFailure: (Exception) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid
        db.collection("personal_details").document(uid.toString()).get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val queryDocumentSnapshots = task.result
                    if (queryDocumentSnapshots != null && queryDocumentSnapshots.exists()) {
                        val data = queryDocumentSnapshots.data
                        val tokenNumber = data?.get("tokenNumber").toString()
                        val name = data?.get("name").toString()
                        val designation = data?.get("designation").toString()
                        val qualification = data?.get("qualification").toString()
                        val dob = data?.get("dob").toString()
                        val specialization = data?.get("specialization").toString()
                        val presentAddress = data?.get("presentAddress").toString()
                        val address = data?.get("address").toString()
                        val phoneNumber = data?.get("phoneNumber").toString()
                        val bloodGroup = data?.get("bloodGroup").toString()

                        val personalDetailsData = PersonalDetailsData(
                            tokenNumber = tokenNumber,
                            dob = dob,
                            name = name,
                            designation = designation,
                            qualification = qualification,
                            specialization = specialization,
                            presentAddress = presentAddress,
                            address = address,
                            phoneNumber = phoneNumber,
                            bloodGroup = bloodGroup
                        )
                        onSuccess(personalDetailsData)
                    } else {
                        onFailure(Exception("Document does not exist"))
                    }
                } else {
                    onFailure(task.exception ?: Exception("Unknown exception"))
                }
            }
    }
}
