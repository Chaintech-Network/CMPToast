package org.example.project

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import multiplatform.network.cmptoast.ToastHost
import network.chaintech.cmptoastdemo.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        App()

        ToastHost() // *** Important : Include this line to show the ToastHost
    }
}