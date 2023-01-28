package com.insecticidepls.gmailui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.insecticidepls.gmailui.model.GmailMenuData
import com.insecticidepls.gmailui.utils.Constants

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

@Composable
fun GmailMenu(
    scrState: ScrollState,
    modifier: Modifier = Modifier
) {
    Column (modifier.verticalScroll(scrState).background(MaterialTheme.colorScheme.background).width(300.dp)) {
        Text(text = "Gmail",
            modifier = Modifier.padding(
                start = Constants.PADDING_DEFAULT.dp,
                top = Constants.PADDING_DEFAULT.dp
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
                            bottom = Constants.PADDING_DEFAULT.dp,
                            top = Constants.PADDING_DEFAULT.dp
                        ))
                }

                item.isHeader -> {
                    Text(
                        text = item.title!!,
                        fontWeight= FontWeight.Light,
                        modifier = Modifier.padding(
                            start = Constants.PADDING_DEFAULT.dp,
                            bottom = Constants.PADDING_DEFAULT.dp,
                            top = Constants.PADDING_DEFAULT.dp
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
    Row(
        modifier = modifier.fillMaxWidth()
            .heightIn(Constants.HEIGHT_MODIFIER_DRAWER.dp)
            .padding(top = Constants.PADDING_MODIFIER_DRAWER.dp)
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(Constants.WEIGHT_DRAWER_IMAGE)
        )
        Text(text = item.title, modifier = Modifier.weight(Constants.WEIGHT_DRAWER_TEXT))
    }
}
