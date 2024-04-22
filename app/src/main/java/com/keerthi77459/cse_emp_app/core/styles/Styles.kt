package com.keerthi77459.cse_emp_app.core.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.keerthi77459.cse_emp_app.R

class Styles {

    private val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val appBarTextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(
            Font(googleFont = GoogleFont(name = "Poppins"), fontProvider = provider)
        ),
        fontSize = 20.sp
    )

    val bigText = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(
            Font(googleFont = GoogleFont(name = "Poppins"), fontProvider = provider)
        ),
        fontSize = 24.sp
    )

    val mediumText = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily(
            Font(googleFont = GoogleFont(name = "Poppins"), fontProvider = provider)
        ),
        fontSize = 16.sp
    )

    val mediumText1 = TextStyle(
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontFamily = FontFamily(
            Font(googleFont = GoogleFont(name = "Raleway"), fontProvider = provider)
        ),
        fontSize = 16.sp
    )

    val mediumText2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        color = Color.Black,
        fontFamily = FontFamily(
            Font(googleFont = GoogleFont(name = "EB Garamond"), fontProvider = provider)
        ),
        fontSize = 16.sp
    )
}