package com.keerthi77459.cse_emp_app.online_courses_feature.domain.services

import com.google.firebase.firestore.FirebaseFirestore
import com.keerthi77459.cse_emp_app.login_feature.data.api.Auth
import com.keerthi77459.cse_emp_app.online_courses_feature.data.OnlineCoursesData
import kotlin.random.Random

class InsertOnlineCourseDetails {
    fun insertOnlineCourseDetails(onlineCoursesData: OnlineCoursesData) {
        println(onlineCoursesData.course)
        println(onlineCoursesData.offeredBy)
        println(onlineCoursesData.startDate)
        println(onlineCoursesData.endDate)
        println(onlineCoursesData.grade)

        val uid = Auth().auth.uid
        val courseId = generateRandomSequence()

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val reference =
            db.collection("online_courses").document(uid.toString()).collection("courses")
                .document(courseId)

        reference.set(onlineCoursesData).addOnSuccessListener {
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