package com.eonarma.kmpcalculator.domain.model

data class CalculatorState(
    val operand1: String = "",
    val operand2: String = "",
    val operator: Operation? = null,
    val result: String? = null
)