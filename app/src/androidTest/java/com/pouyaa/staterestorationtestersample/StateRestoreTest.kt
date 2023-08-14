package com.pouyaa.staterestorationtestersample

import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class StateRestoreTest {
    @get: Rule
    val rule = createComposeRule()

    @Test
    fun testStateRestoration() {
        val restorationTester = StateRestorationTester(rule)

        restorationTester.setContent { ClickCounter() }
        rule.onNodeWithText("Add 1").performClick()
        restorationTester.emulateSavedInstanceStateRestore()

        // Checking to make sure saveable variable survived the configuration change correctly
        rule.onNodeWithText("Saveable count: 1").assertExists()

        // Checking to make sure non-saveable parameter did not survive the configuration change
        rule.onNodeWithText("Count: 0").assertExists()
    }
}