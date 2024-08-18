package com.eonarma.kmpcalculator.domain.use_case

import com.eonarma.kmpcalculator.domain.model.CalculatorState

class InverseSignUseCase {
    fun execute(calculatorState: CalculatorState): CalculatorState {
        val updatedOperand = when {
            calculatorState.operator == null -> calculatorState.operand1
            else -> calculatorState.operand2 ?: ""
        }.toDoubleOrNull()?.let { it * -1 }?.toString() ?: ""

        return if (calculatorState.operator == null) {
            calculatorState.copy(operand1 = updatedOperand)
        } else {
            calculatorState.copy(operand2 = updatedOperand)
        }
    }
}