package com.eonarma.kmpcalculator.domain.model

sealed class Action() {
    data class EnterNumber(val number: String): Action()
    data class EnterOperator(val operation: Operation): Action()
    object Clear: Action()
    object InverseSign: Action()
    object Delete: Action()
    object Equals: Action()
    object Decimal: Action()
}