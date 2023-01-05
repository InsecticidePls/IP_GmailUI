package com.insecticidepls.gmailui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.insecticidepls.gmailui.utils.Constants

@Composable
fun GMailFab(
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    //Reminder: Find something to apply here
    modifier.padding()

    if (scrollState.value > Constants.SCROLL_VALUE) {
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
        )
    } else {
        FloatingActionButton(
            onClick = {},
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "")
        }
    }
}
