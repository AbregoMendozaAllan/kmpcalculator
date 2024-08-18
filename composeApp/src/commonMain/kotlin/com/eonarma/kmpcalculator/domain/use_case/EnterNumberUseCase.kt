package com.eonarma.kmpcalculator.domain.use_case

import com.eonarma.kmpcalculator.domain.model.CalculatorState

class EnterNumberUseCase {
    fun execute(calculatorState: CalculatorState, number: String): CalculatorState {
        return if (calculatorState.operator == null) {
            calculatorState.copy(
                operand1 = "${calculatorState.operand1}$number"
            )
        } else {
            calculatorState.copy(
                operand2 = "${calculatorState.operand2 ?: ""}$number"
            )
        }
    }
}