package com.example.parship.ui

import androidx.compose.ui.graphics.Color
import com.example.parship.ButtonViewModel.Companion.ELITE_PARTNER_TEXT
import com.example.parship.ButtonViewModel.Companion.PARSHIP_TEXT


/**
 * Created by nurseiit.tursunkulov on 11.11.2023
 * ScreenState
 */
enum class ScreenState(val title: String,val color: Color){
     Parship( PARSHIP_TEXT, Color.Red),
     ElitePartner( ELITE_PARTNER_TEXT, Color.Blue)
}
