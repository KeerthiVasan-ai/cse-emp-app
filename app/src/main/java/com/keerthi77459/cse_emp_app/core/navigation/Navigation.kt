package com.keerthi77459.cse_emp_app.core.navigation

import com.keerthi77459.cse_emp_app.personal_details_features.presentation.screens.PersonalDetailsScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keerthi77459.cse_emp_app.academic_features.presentation.screen.AcademicDetailsForm
import com.keerthi77459.cse_emp_app.academic_features.presentation.screen.AcademicScreen
import com.keerthi77459.cse_emp_app.main_features.presentation.screens.MainScreen
import com.keerthi77459.cse_emp_app.online_courses_feature.presentation.screens.OnlineCoursesScreen
import com.keerthi77459.cse_emp_app.online_courses_feature.presentation.screens.OnlineCoursesView
import com.keerthi77459.cse_emp_app.publication_features.presentation.screens.PublicationScreen
import com.keerthi77459.cse_emp_app.publication_features.presentation.screens.PublicationView
import com.keerthi77459.cse_emp_app.recognition_features.presentation.screens.RecognitionScreen
import com.keerthi77459.cse_emp_app.recognition_features.presentation.screens.RecognitionView

@Composable
fun NavigationMap(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.MainScreen.route) {
        composable(route = NavigationScreen.MainScreen.route) {
            MainScreen(context, navController)
        }
        composable(route = NavigationScreen.PersonalDetailsScreen.route) {
            PersonalDetailsScreen()
        }
        composable(route = NavigationScreen.AcademicScreen.route) {
            AcademicScreen(navController)
        }
        composable(route = NavigationScreen.AcademicDetailsForm.route){
            AcademicDetailsForm()
        }
        composable(route = NavigationScreen.PublicationDetailsScreen.route) {
            PublicationScreen(navController, context)
        }
        composable(route = NavigationScreen.PublicationView.route){
            PublicationView(navController)
        }
        composable(route= NavigationScreen.RecognitionScreen.route){
            RecognitionScreen()
        }
        composable(route = NavigationScreen.RecognitionView.route){
            RecognitionView(navController)
        }
        composable(route = NavigationScreen.OnlineCoursesView.route){
           OnlineCoursesView(navController)
        }
        composable(route = NavigationScreen.OnlineCoursesScreen.route){
            OnlineCoursesScreen()
        }
    }
}
