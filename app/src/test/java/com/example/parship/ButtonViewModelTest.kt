package com.example.parship

import androidx.compose.ui.graphics.Color
import com.example.parship.ButtonViewModel.Companion.ELITE_PARTNER_TEXT
import com.example.parship.ButtonViewModel.Companion.PARSHIP_TEXT
import com.example.parship.ui.ScreenState
import kotlinx.coroutines.Dispatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
/**
 * Created by nurseiit.tursunkulov on 11.11.2023
 * ButtonViewModelTest
 */
class ButtonViewModelTest {
    @Before
    fun setup() {
        // Set the main dispatcher to a test dispatcher before running the test
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher after the test is complete
        Dispatchers.resetMain()
    }
    @Test
    fun toggleText() {
        val viewModel = ButtonViewModel()
        assert(viewModel.screenState.value == ScreenState.Parship)
        assert(viewModel.screenState.value.color == Color.Red)
        assert(viewModel.screenState.value.title == PARSHIP_TEXT)
        viewModel.toggleText()
        assert(viewModel.screenState.value.color == Color.Blue)
        assert(viewModel.screenState.value == ScreenState.ElitePartner)
        assert(viewModel.screenState.value.title == ELITE_PARTNER_TEXT)
        viewModel.toggleText()
        assert(viewModel.screenState.value == ScreenState.Parship)
        assert(viewModel.screenState.value.title == PARSHIP_TEXT)
        assert(viewModel.screenState.value.color == Color.Red)
    }
}