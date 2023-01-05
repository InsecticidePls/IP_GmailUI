package com.insecticidepls.gmailui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.insecticidepls.gmailui.model.GmailMenuData

private const val PADDING_DEFAULT = 20
private const val PADDING_MODIFIER_DRAWER = 16
private const val HEIGHT_MODIFIER_DRAWER = 50

private const val WEIGHT_DRAWER_TEXT = 2f
private const val WEIGHT_DRAWER_IMAGE = 0.5f


@Composable
fun GmailMenu(
    scrState: ScrollState,
    modifier: Modifier = Modifier
) {
    //Reminder: Find something to apply here (Compose rule: modifier parameter)
    modifier.padding()

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

    Column (Modifier.verticalScroll(scrState).background(Color.White).width(300.dp)) {
        Text(text = "Gmail",
            modifier = Modifier.padding(
                start = PADDING_DEFAULT.dp,
                top = PADDING_DEFAULT.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Red
        )

        gmailList.forEach{
            item ->
            when {
                item.isDivider -> {
                    Divider(
                        modifier = Modifier.padding(
                            bottom = PADDING_DEFAULT.dp,
                            top = PADDING_DEFAULT.dp
                        ))
                }

                item.isHeader -> {
                    Text(
                        text = item.title!!,
                        fontWeight= FontWeight.Light,
                        modifier = Modifier.padding(
                            start = PADDING_DEFAULT.dp,
                            bottom = PADDING_DEFAULT.dp,
                            top = PADDING_DEFAULT.dp
                        ))
                }
                else -> {
                    GDrawerComposer(item = item)
                }
            }
        }
    }
}

@Composable
fun GDrawerComposer (
    item: GmailMenuData,
    modifier: Modifier = Modifier
) {
    //Reminder: Find something to apply here (Compose rule: modifier parameter)
    modifier.padding()

    Row(
        modifier = Modifier.fillMaxWidth()
            .height(HEIGHT_MODIFIER_DRAWER.dp)
            .padding(top = PADDING_MODIFIER_DRAWER.dp)
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(WEIGHT_DRAWER_IMAGE)
        )
        Text(text = item.title, modifier = Modifier.weight(WEIGHT_DRAWER_TEXT))
    }
}


