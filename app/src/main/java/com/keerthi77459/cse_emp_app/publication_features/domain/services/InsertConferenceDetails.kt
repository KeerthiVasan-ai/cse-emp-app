package com.keerthi77459.cse_emp_app.publication_features.domain.services

import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.publication_features.data.repository.ConferenceData
import kotlin.random.Random

class InsertConferenceDetails(val context: Context) {
    fun insertConferenceDetails(conferenceData: ConferenceData) {
        println(conferenceData.authorName)
        println(conferenceData.paperTitle)
        println(conferenceData.conferenceName)
        println(conferenceData.conducted)
        println(conferenceData.date)
        println(conferenceData.proceedingName)
        println(conferenceData.issnNo)

        val uid = Auth().auth.uid

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val overallReference = db.collection("publication_details")
            .document(uid.toString())
            .collection("conferences")
            .document("conferences_details")

        val reference = overallReference.collection("details")
            .document(generateRandomSequence())

        reference.set(conferenceData).addOnSuccessListener {
            println("SUCCESS")
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_LONG).show()
        }.addOnFailureListener{e->
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