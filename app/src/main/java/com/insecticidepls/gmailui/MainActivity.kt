package com.insecticidepls.gmailui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.insecticidepls.gmailui.components.GmailMenu
import com.insecticidepls.gmailui.components.MainAppBar
import com.insecticidepls.gmailui.ui.theme.IP_GmailUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IP_GmailUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    GmailUI()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GmailUI() {
    val scafState = rememberScaffoldState()
    val corScope = rememberCoroutineScope()
    val scrState = rememberScrollState()

    Scaffold (scaffoldState = scafState, topBar = { MainAppBar(scafState, corScope)},
    drawerContent = { GmailMenu(scrState) }) {}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IP_GmailUITheme {
        GmailUI()
    }
}