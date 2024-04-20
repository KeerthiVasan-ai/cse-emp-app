package com.keerthi77459.cse_emp_app.recognition_features.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.recognition_features.data.repository.RecognitionData
import kotlin.random.Random

class InsertRecognitionDetails {
    fun insertRecognitionDetails(recognitionData: RecognitionData) {
        println(recognitionData.name)
        println(recognitionData.givenBy)
        println(recognitionData.date)

        val uid = Auth().auth.uid
        val recognitionId = generateRandomSequence()

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val reference =
            db.collection("recognition_details").document(uid.toString()).collection("awards")
                .document(recognitionId)

        reference.set(recognitionData).addOnSuccessListener {
            println("SUCCESS")
//            Toast.makeText(
//                context,
//                "Your Course has been added to Firebase Firestore",
//                Toast.LENGTH_SHORT
//            ).show()

        }.addOnFailureListener { e ->
            println(e.stackTrace)
//            Toast.makeText(context, "Fail to add course \n$e", Toast.LENGTH_SHORT).show()
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