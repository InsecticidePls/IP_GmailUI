package com.insecticidepls.gmailui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.insecticidepls.gmailui.model.BottomMenuData


@Composable
fun BottomAppBar(
    modifier: Modifier = Modifier
) {
    //Reminder: Find something to apply here (Compose rule: modifier parameter)
    modifier.padding()

    val bottomItems = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        bottomItems.forEach {
            BottomNavigationItem(
                selected = false,
                onClick = {},
                icon = { Icon(imageVector = it.icon, contentDescription = null) }
            )
        }
    }
}
