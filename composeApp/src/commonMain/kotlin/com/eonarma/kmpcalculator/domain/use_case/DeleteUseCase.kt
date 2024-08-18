package com.eonarma.kmpcalculator.domain.use_case

import com.eonarma.kmpcalculator.domain.model.CalculatorState

class DeleteUseCase {
    fun execute(calculatorState: CalculatorState): CalculatorState {

        return when {
            calculatorState.operator == null -> calculatorState.copy(
                operand1 = calculatorState.operand1.dropLast(1)
            )
            calculatorState.operand2 == "" -> calculatorState.copy(operator = null)
            else -> calculatorState.copy(
                operand2 = calculatorState.operand2.dropLast(1)
            )

        }
    }
}