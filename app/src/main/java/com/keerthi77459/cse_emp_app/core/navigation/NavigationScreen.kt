package com.keerthi77459.cse_emp_app.core.navigation

sealed class NavigationScreen(val route: String) {
    data object MainScreen : NavigationScreen("main_screen")
    data object PersonalDetailsScreen : NavigationScreen("Personal Details")
    data object AcademicDetailsForm: NavigationScreen("academics_details_form")
    data object AcademicScreen : NavigationScreen("Academics")
    data object PublicationDetailsScreen : NavigationScreen("publication_screen")
    data object PublicationView: NavigationScreen("Publications")
    data object RecognitionView: NavigationScreen("Recognition")
    data object RecognitionScreen: NavigationScreen("recognition_view")
    data object OnlineCoursesView: NavigationScreen("Online Courses")
    data object OnlineCoursesScreen: NavigationScreen("online_course_screen")
}