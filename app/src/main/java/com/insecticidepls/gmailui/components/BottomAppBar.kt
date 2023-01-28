package com.insecticidepls.gmailui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.insecticidepls.gmailui.model.BottomMenuData

@Composable
fun BottomAppBar(
    modifier: Modifier = Modifier
) {
    val bottomItems = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )

    NavigationBar(
        modifier.height(50.dp),
        tonalElevation = 2.dp
    ) {
        bottomItems.forEach {
            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = { Icon(imageVector = it.icon, contentDescription = "") }
            )
        }
    }
}
