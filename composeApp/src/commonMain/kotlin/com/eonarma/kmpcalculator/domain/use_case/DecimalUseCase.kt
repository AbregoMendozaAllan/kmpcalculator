package com.eonarma.kmpcalculator.domain.use_case

import com.eonarma.kmpcalculator.domain.model.CalculatorState

class DecimalUseCase {
    fun execute(calculatorState: CalculatorState): CalculatorState {
        fun notContainsDecimal(string: String): String {
            var result = string
            if (!string.contains('.')) result += "."
            return result
        }
        return when {
            calculatorState.operator == null -> calculatorState.copy(
                operand1 = notContainsDecimal(calculatorState.operand1)
            ) else -> calculatorState.copy(
                operand2 = notContainsDecimal(calculatorState.operand2)
            )
        }
    }
}