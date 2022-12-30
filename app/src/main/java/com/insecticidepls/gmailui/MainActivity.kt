package com.insecticidepls.gmailui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
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
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    GmailUI()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GmailUI(
    modifier: Modifier = Modifier
) {

    //Reminder: Find something to apply here
    modifier.padding()

    val scafState = rememberScaffoldState()
    val corScope = rememberCoroutineScope()
    val scrState = rememberScrollState()

    Scaffold (
        scaffoldState = scafState,
        topBar = { MainAppBar(scafState, corScope) },
        drawerContent = { GmailMenu(scrState) },
        bottomBar = { BottomAppBar() },
        floatingActionButton = { GMailFab(scrState) }
        ) {
        MailScreen(it, scrState)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IPGmailUITheme {
        GmailUI()
    }
}
