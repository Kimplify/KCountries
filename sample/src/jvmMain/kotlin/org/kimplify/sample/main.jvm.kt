package org.kimplify.sample

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Countries Sample - Desktop"
    ) {
        App()
    }
}
