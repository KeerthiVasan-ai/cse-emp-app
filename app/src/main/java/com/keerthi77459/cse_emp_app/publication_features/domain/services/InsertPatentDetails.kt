package com.keerthi77459.cse_emp_app.publication_features.domain.services

import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.publication_features.data.repository.PatentData
import kotlin.random.Random

class InsertPatentDetails(val context: Context) {
    fun insertPatentDetails(patentData: PatentData) {
        println(patentData.patentTitle)
        println(patentData.fileNo)
        println(patentData.date)
        println(patentData.status)

        val uid = Auth().auth.uid

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val overallReference = db.collection("publication_details")
            .document(uid.toString())
            .collection("patents")
            .document("patents_details")

        val reference = overallReference.collection("details")
            .document(generateRandomSequence())

        reference.set(patentData).addOnSuccessListener {
            println("SUCCESS")
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_LONG).show()

        }.addOnFailureListener { e ->
            println(e.stackTrace)
        }
    }

    private fun generateRandomSequence(): String {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9') // Define the character pool
        return (1..12)
            .map { Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }
}