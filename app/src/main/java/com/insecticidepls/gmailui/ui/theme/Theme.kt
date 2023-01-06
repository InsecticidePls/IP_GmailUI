package com.insecticidepls.gmailui.ui.theme

import android.app.Activity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun IPGmailUITheme(
    content: @Composable () -> Unit
) {
    LightColorPalette

    val view = LocalView.current
    val activity = view.context as Activity
    val window = (activity).window

    window.context

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
