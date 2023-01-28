package com.insecticidepls.gmailui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun GmailAccount(openDialog: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false))
    {
        AccountDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountDialogUI(
    openDialog:MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    Card (
        shape = RoundedCornerShape(8.dp),
            ){
        Column(modifier.background(Color.White)) {}
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,


        ) {
            IconButton(onClick = { openDialog.value = false }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "")
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 8.dp)) {
            Image(
                painter = painterResource(id = com.insecticidepls.gmailui.R.drawable.profile),
                contentDescription = "Profile",
                Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
            )
            Column(
                Modifier
                    .weight(2.0f)
                    .padding(start = 16.dp, bottom = 16.dp)
            ) {
                Text(text = "Renato Santos", fontWeight = FontWeight.SemiBold)
                Text(text = "abc@123.com")
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp), horizontalArrangement =
            Arrangement.Start
        ) {
            Card(
                modifier = Modifier.padding(start = 56.dp),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = Color.Gray)
            ) {
                Text(
                    text = "Manage your Google Account",
                    Modifier.padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        Divider(Modifier.padding(8.dp))
        EntryGenerator(icon = Icons.Default.Cloud, title = "Storage used: 50% of 15 GB")
        Divider(Modifier.padding(8.dp))
        EntryGenerator(icon = Icons.Default.PersonAddAlt, title = "Add another account")
        EntryGenerator(
            icon = Icons.Outlined.ManageAccounts,
            title = "Manage accounts on this device"
        )
        Divider(Modifier.padding(top = 8.dp, bottom = 8.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Privacy Policy")
            Card(
                Modifier
                    .size(5.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(Color.Black)
            ) {}
            Text(text = "Terms Of Service")
        }
    }
}

@Composable
fun EntryGenerator(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(start = 16.dp)) {
        IconButton(onClick = { }) {
            Icon(
                imageVector = icon,
                contentDescription = ""
            )
        }
        Text(text = title, Modifier.padding(top = 16.dp,start = 8.dp), fontWeight = FontWeight.SemiBold)
    }
}
