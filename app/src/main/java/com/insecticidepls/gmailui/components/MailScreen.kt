package com.insecticidepls.gmailui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.insecticidepls.gmailui.mailList
import com.insecticidepls.gmailui.model.MailData

@Composable
fun MailScreen(
    paddingValues: PaddingValues,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.padding(paddingValues)) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
            .scrollable(scrollState, Orientation.Vertical)
        ) {
            items(mailList) {
                mailData ->
                MailItem(mailData = mailData)
            }
        }
    }
}

@Composable
fun MailItem(
    mailData: MailData,
    modifier: Modifier = Modifier
) {
    Row(modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)) {
        Card(
            Modifier
                .padding(
                    end = 16.dp
                )
                .size(42.dp)
                .clip(CircleShape)
        ) {
            Text(
                text = mailData.userName[0].toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top = 5.dp),
                fontSize = 24.sp,
            )
        }

        Column(
            modifier = Modifier.weight(2f)
        ) {
            Text(
                mailData.userName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                mailData.subject,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                mailData.body,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
        }

        Column{
            Text(text = mailData.timeStamp)
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 16.dp)
            ) {
                Icon(imageVector = Icons.Outlined.StarOutline,"")
            }
        }
    }
}
