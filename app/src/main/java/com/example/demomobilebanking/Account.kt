package com.example.demomobilebanking

import androidx.compose.ui.graphics.Color

data class Account(
    val id : String,
    val name : String,
    val accountNumber: String,
    val accountBalance : String,
    val accountType : String,
    val labelColor : Color
)
