package com.insecticidepls.gmailui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class GmailMenuData (
    val icon: ImageVector? = null,
    val title: String? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false
)
{
    object Primary: GmailMenuData(
        icon = Icons.Outlined.Inbox,
        title = "Primary"
    )
    object Updates: GmailMenuData(
        icon = Icons.Outlined.Info,
        title = "Updates"
    )

    object Starred: GmailMenuData(
        icon = Icons.Outlined.StarOutline,
        title = "Starred"
    )
    object Snoozed: GmailMenuData(
        icon = Icons.Outlined.Timer,
        title = "Snoozed"
    )
    object Important: GmailMenuData(
        icon = Icons.Outlined.Label,
        title = "Important"
    )
    object Sent: GmailMenuData(
        icon = Icons.Outlined.Send,
        title = "Sent"
    )
    object Spam: GmailMenuData(
        icon = Icons.Outlined.Warning,
        title = "Spam"
    )
    object Trash: GmailMenuData(
        icon = Icons.Outlined.Delete,
        title = "Trash"
    )
    object Schedule: GmailMenuData(
        icon = Icons.Outlined.Schedule,
        title = "Scheduled"
    )
    object Outbox: GmailMenuData(
        icon = Icons.Outlined.Outbox,
        title = "Outbox"
    )
    object Draft: GmailMenuData(
        icon = Icons.Outlined.Drafts,
        title = "Drafts"
    )
    object AllMail: GmailMenuData(
        icon = Icons.Outlined.Mail,
        title = "All Mail"
    )
    object Calendar: GmailMenuData(
        icon = Icons.Outlined.CalendarToday,
        title = "Calendar"
    )
    object Contacts: GmailMenuData(
        icon = Icons.Outlined.Contacts,
        title = "Contacts"
    )
    object Setting: GmailMenuData(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )
    object Help: GmailMenuData(
        icon = Icons.Outlined.Help,
        title = "Help & FeedBack"
    )
    object Divider: GmailMenuData(
        isDivider = true
    )
    object AllLabels: GmailMenuData(
        isHeader = true,
        title = "All Labels"
    )
    object GoogleApps: GmailMenuData(
        isHeader = true,
        title = "Google Apps"
    )
}
