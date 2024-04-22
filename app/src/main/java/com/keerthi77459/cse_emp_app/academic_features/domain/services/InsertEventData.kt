package com.keerthi77459.cse_emp_app.academic_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.academic_features.data.repository.AttendedData
import com.keerthi77459.cse_emp_app.academic_features.data.repository.ConductedData
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import kotlin.random.Random

class InsertEventData {
    fun insertAttendedData(attendedData: AttendedData) {

        println(attendedData.event)
        println(attendedData.year)
        println(attendedData.name)
        println(attendedData.conductedBy)
        println(attendedData.startDate)
        println(attendedData.endDate)

        val db = FirebaseFirestore.getInstance()
        val auth = Auth().auth.uid

        val reference = db.collection("academic_details").document(auth.toString())

        reference.collection("attended")
            .document(generateRandomSequence())
            .set(attendedData)
            .addOnSuccessListener {
                println("SUCCESS")
            }.addOnFailureListener {
                println(it.message.toString())
            }
        reference.collection("attended").get()
            .addOnSuccessListener { documents ->
                val attendCount = documents.size()

                reference.update("attendedCount", attendCount)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { _ ->
                    }
            }
            .addOnFailureListener { _ ->
            }

    }

    fun insertConductedData(conductedData: ConductedData) {
        val db = FirebaseFirestore.getInstance()
        val auth = Auth().auth.uid


        val reference = db.collection("academic_details").document(auth.toString())


        reference.collection("conducted")
            .document(generateRandomSequence())
            .set(conductedData)
            .addOnSuccessListener {
                println("SUCCESS")
            }.addOnFailureListener {
                println(it.message.toString())
            }
        reference.collection("conducted").get()
            .addOnSuccessListener { documents ->
                val attendCount = documents.size()

                reference.update("conductedCount", attendCount)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { _ ->
                    }
            }
            .addOnFailureListener { _ ->
            }
    }

    private fun generateRandomSequence(): String {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..12)
            .map { Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }
}
