package com.keerthi77459.cse_emp_app.core.navigation

sealed class NavigationScreen(val route: String) {
    data object LoginScreen : NavigationScreen("Login Screen")
    data object MainScreen : NavigationScreen("main_screen")
    data object PersonalDetailsScreen : NavigationScreen("Personal Details")
    data object AcademicScreen : NavigationScreen("academics_details_form")
    data object AcademicView : NavigationScreen("Academics")
    data object PublicationScreen : NavigationScreen("publication_screen")
    data object PublicationView : NavigationScreen("Publications")
    data object RecognitionView : NavigationScreen("Recognition")
    data object RecognitionScreen : NavigationScreen("recognition_view")
    data object OnlineCoursesView : NavigationScreen("Online Courses")
    data object OnlineCoursesScreen : NavigationScreen("online_course_screen")
    data object ResetPassword : NavigationScreen("rest")
}