package com.insecticidepls.gmailui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.insecticidepls.gmailui.GmailUI
import com.insecticidepls.gmailui.R
import com.insecticidepls.gmailui.ui.theme.IP_GmailUITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    Box (modifier = Modifier.padding(10.dp)){
        Card (
            modifier = Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(10.dp)
                ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)) {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(Icons.Default.Menu, "Menu")
                }
                Text(text = "Search in mail", modifier = Modifier.weight(2f))
                Icon(painter = painterResource(id = R.drawable._2_profile),
                    contentDescription = "Profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray))
            }
        }
    }
}

@Preview
@Composable
fun DefPreview() {
    IP_GmailUITheme{
        GmailUI()
    }
}