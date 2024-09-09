package com.chev.mobilebank.data

import androidx.compose.ui.graphics.vector.ImageVector
import java.math.BigDecimal

data class Currencies(
    val name: String,
    val buy: BigDecimal,
    val sell: BigDecimal,
    val icon: ImageVector
)
