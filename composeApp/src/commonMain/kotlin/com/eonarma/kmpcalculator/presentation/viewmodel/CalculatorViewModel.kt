package com.eonarma.kmpcalculator.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.eonarma.kmpcalculator.domain.model.Action
import com.eonarma.kmpcalculator.domain.model.CalculatorState
import com.eonarma.kmpcalculator.domain.model.Operation
import com.eonarma.kmpcalculator.domain.use_case.CalculatorUseCases

class CalculatorViewModel(
    private val calculatorUseCases: CalculatorUseCases
): ViewModel() {
    var state: CalculatorState by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: Action) {
        when(action) {
            is Action.Clear -> clear()
            is Action.InverseSign -> inverseSign()
            is Action.Delete -> delete()
            is Action.Equals -> equals()
            is Action.Decimal -> decimal()
            is Action.EnterNumber -> enterNumber(action.number)
            is Action.EnterOperator -> enterOperator(action.operation)
        }

    }
    private fun clear() {
        val updatedState = calculatorUseCases.clear.execute(state)
        state = updatedState
    }

    private fun inverseSign() {
        state = calculatorUseCases.inverseSign.execute(state)
    }

    private fun delete() {
        val updatedState = calculatorUseCases.delete.execute(state)
        state = updatedState
    }

    private fun equals() {
        state = calculatorUseCases.calculate.execute(state)
    }

    private fun decimal() {
        state = calculatorUseCases.decimal.execute(state)
    }

    private fun enterNumber(number: String) {
        state = calculatorUseCases.enterNumber.execute(state, number)
    }

    private fun enterOperator(operator: Operation) {
        state = calculatorUseCases.enterOperator.execute(state, operator)
    }
}

