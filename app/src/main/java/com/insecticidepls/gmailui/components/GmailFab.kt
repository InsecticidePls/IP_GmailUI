package com.insecticidepls.gmailui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

private const val SCROLL_VALUE = 100

@Composable
fun GMailFab(
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    if (scrollState.value > SCROLL_VALUE) {
        ExtendedFloatingActionButton(
            text = {
                Text(
                    text = "Compose",
                    fontSize = 16.sp
                )
            },
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Default.Edit,"")
            },
            backgroundColor = MaterialTheme.colors.surface,
        )
    } else {
        FloatingActionButton(
            onClick = {},
            modifier = modifier.background(MaterialTheme.colors.background)
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "")
        }
    }
}
