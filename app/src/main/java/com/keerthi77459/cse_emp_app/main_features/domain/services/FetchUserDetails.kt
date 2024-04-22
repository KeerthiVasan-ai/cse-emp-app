package com.keerthi77459.cse_emp_app.main_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth

class FetchUserDetails {
    fun fetchUserName(onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val uid = Auth().auth.uid

        db.collection("personal_details").document(uid.toString())
            .get().addOnCompleteListener {
                if (it.isSuccessful) {
                    val queryDocumentSnapshot = it.result
                    if (queryDocumentSnapshot != null && queryDocumentSnapshot.exists()) {
                        val data = queryDocumentSnapshot.data
                        var name = ""
                        data?.let {
                            name = data["name"].toString()
                        }
                        onSuccess(name)
                    } else {
                        onFailure(Exception("Document does not exist"))
                    }
                } else {
                    onFailure(it.exception ?: Exception("Unknown exception"))
                }
            }
    }
}