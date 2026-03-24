package org.kimplify.sample

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.window.ComposeViewport
import countries.sample.generated.resources.Res
import countries.sample.generated.resources.noto_color_emoji
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.preloadFont
import kotlin.js.ExperimentalWasmJsInterop

@OptIn(
    ExperimentalResourceApi::class, ExperimentalWasmJsInterop::class,
    ExperimentalComposeUiApi::class,
)
fun main() {
    ComposeViewport {
        val fontFamilyResolver = LocalFontFamilyResolver.current
        val emojiFont by preloadFont(Res.font.noto_color_emoji)
        val fontsLoaded = remember { mutableStateOf(false) }

        if (fontsLoaded.value) {
            App()
        }

        LaunchedEffect(Unit, emojiFont) {
            if (emojiFont != null) {
                fontFamilyResolver.preload(FontFamily(emojiFont!!))
                fontsLoaded.value = true

            }
        }
    }
}