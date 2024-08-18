package com.eonarma.kmpcalculator.domain.model

sealed class Operation(val operator: String) {
    object Multiplication: Operation(operator = "*")
    object Division: Operation(operator = "÷")
    object Addition: Operation(operator = "+")
    object Subtraction: Operation(operator = "-")
}