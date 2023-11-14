package com.example.parship

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.parship.ui.ParshipScreen
import com.example.parship.ui.theme.ParshipTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.parship", appContext.packageName)
    }

    @Test
    fun myTest() {
        composeTestRule.setContent {
            ParshipTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ParshipScreen(ButtonViewModel())
                    }
                }
            }
        }
        composeTestRule.onNodeWithText(ButtonViewModel.PARSHIP_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(ButtonViewModel.PARSHIP_TEXT).assertTextColor(Color.Red)
        composeTestRule.onNodeWithText("Toggle").performClick()
        composeTestRule.onNodeWithText(ButtonViewModel.ELITE_PARTNER_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(ButtonViewModel.ELITE_PARTNER_TEXT).assertTextColor(Color.Blue)
    }

    fun SemanticsNodeInteraction.assertTextColor(
        color: Color
    ): SemanticsNodeInteraction = assert(isOfColor(color))

    private fun isOfColor(color: Color): SemanticsMatcher = SemanticsMatcher(
        "${SemanticsProperties.Text.name} is of color '$color'"
    ) {
        val textLayoutResults = mutableListOf<TextLayoutResult>()
        it.config.getOrNull(SemanticsActions.GetTextLayoutResult)
            ?.action
            ?.invoke(textLayoutResults)
        return@SemanticsMatcher if (textLayoutResults.isEmpty()) {
            false
        } else {
            textLayoutResults.first().layoutInput.style.color == color
        }
    }
}