package com.duitddu.pokdex.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val appFontFamily: FontFamily = FontFamily.Default

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Medium
    ),
    h2 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium
    ),
    h3 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    h4 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    h5 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    h6 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    subtitle1 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light
    ),
    subtitle2 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 11.sp,
        fontWeight = FontWeight.Light
    ),
    body1 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    body2 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal
    ),
    button = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    caption = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    ),
    overline = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )
)