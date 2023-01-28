package com.insecticidepls.gmailui.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColorScheme(
    primary = Purple500,
    onPrimary = Purple700,
    secondary = Teal200
)

@Composable
fun IPGmailUITheme(
    content: @Composable () -> Unit
) {
    LightColorPalette

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
