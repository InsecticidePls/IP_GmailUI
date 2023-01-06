package com.insecticidepls.gmailui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.insecticidepls.gmailui.components.BottomAppBar
import com.insecticidepls.gmailui.components.GMailFab
import com.insecticidepls.gmailui.components.GmailMenu
import com.insecticidepls.gmailui.components.MailScreen
import com.insecticidepls.gmailui.components.MainAppBar
import com.insecticidepls.gmailui.ui.theme.IPGmailUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPGmailUITheme {
                    GmailUI()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GmailUI(
    modifier: Modifier = Modifier
) {

    //Reminder: Find something to apply here
    modifier.padding()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val corScope = rememberCoroutineScope()
    val scrState = rememberScrollState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { GmailMenu(scrState) },
        gesturesEnabled = drawerState.isOpen,
        content = {
            Scaffold (
                topBar = { MainAppBar(drawerState, corScope) },
                bottomBar = { BottomAppBar() },
                floatingActionButton = { GMailFab(scrState) }
            ) {
                MailScreen(it, scrState)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IPGmailUITheme {
        GmailUI()
    }
}
