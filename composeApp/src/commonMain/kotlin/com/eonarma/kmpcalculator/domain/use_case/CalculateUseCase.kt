package com.eonarma.kmpcalculator.domain.use_case

import com.eonarma.kmpcalculator.domain.model.CalculatorState
import com.eonarma.kmpcalculator.domain.model.Operation

class CalculateUseCase {
    fun execute(calculatorState: CalculatorState): CalculatorState {
        // Ensure both operand1, operand2, and operator are present
        val operand1 = calculatorState.operand1.toDoubleOrNull()
        val operand2 = calculatorState.operand2.toDoubleOrNull()
        val operator = calculatorState.operator

        if (operand1 != null && operand2 != null && operator != null) {
            val result = when (operator) {
                is Operation.Addition -> operand1 + operand2
                is Operation.Subtraction -> operand1 - operand2
                is Operation.Multiplication -> operand1 * operand2
                is Operation.Division -> {
                    if (operand2 != 0.0) operand1 / operand2 else Double.NaN
                }
            }
            // Update state with the result and reset operand2 and operator
            return calculatorState.copy(
                operand1 = result.toString(),
                operand2 = "",
                operator = null,
                result = result.toString()
            )
        }

        // If the operation is invalid, return the current state
        return calculatorState
    }
}