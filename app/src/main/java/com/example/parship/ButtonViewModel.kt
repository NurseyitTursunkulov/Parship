package com.example.parship

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parship.ui.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


/**
 * Created by nurseiit.tursunkulov on 11.11.2023
 * ViewModel
 */
class ButtonViewModel : ViewModel() {
    var screenState: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.Parship)
companion object{
    const val PARSHIP_TEXT = "Parship"
    const val ELITE_PARTNER_TEXT = "Elitepartner"
}
    fun toggleText() {
        viewModelScope.launch {
            if (screenState.value == ScreenState.Parship)
                screenState.emit(ScreenState.ElitePartner)
            else
                screenState.emit(ScreenState.Parship)
        }
    }
}