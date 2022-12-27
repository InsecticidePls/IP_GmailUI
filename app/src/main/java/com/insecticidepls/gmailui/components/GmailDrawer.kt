package com.insecticidepls.gmailui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GmailMenu(scrState: ScrollState) {

    val gmailList = listOf(
        GmailMenuData.Divider,
        GmailMenuData.Primary,
        GmailMenuData.Updates,

        GmailMenuData.AllLabels,
        GmailMenuData.Starred,
        GmailMenuData.Snoozed,
        GmailMenuData.Important,
        GmailMenuData.Sent,
        GmailMenuData.Schedule,
        GmailMenuData.Outbox,
        GmailMenuData.Draft,
        GmailMenuData.AllMail,
        GmailMenuData.Spam,
        GmailMenuData.Trash,

        GmailMenuData.GoogleApps,
        GmailMenuData.Calendar,
        GmailMenuData.Contacts,
        GmailMenuData.Divider,
        GmailMenuData.Setting,
        GmailMenuData.Help
    )


    Column (Modifier.verticalScroll(scrState)) {
        Text(text = "Gmail",
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Red
        )

        gmailList.forEach{
            item ->
            when {
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp))
                }

                item.isHeader -> {
                    Text(
                        text = item.title!!,
                        fontWeight= FontWeight.Light,
                        modifier = Modifier.padding(start = 20.dp, bottom = 20.dp, top = 20.dp))
                }
                else -> {
                    GDrawerComposer(item = item)
                }
            }
        }
    }
}

@Composable
fun GDrawerComposer (item: GmailMenuData) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp)
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(0.5f)
        )
        Text(text = item.title, modifier = Modifier.weight(2.0f))
    }
}