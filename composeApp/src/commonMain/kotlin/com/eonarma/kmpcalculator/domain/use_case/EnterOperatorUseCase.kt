package com.eonarma.kmpcalculator.domain.use_case

import com.eonarma.kmpcalculator.domain.model.CalculatorState
import com.eonarma.kmpcalculator.domain.model.Operation

class EnterOperatorUseCase {
    fun execute(calculatorState: CalculatorState, operator: Operation): CalculatorState {
        return if (calculatorState.operand1.any{ !it.isDigit() }) calculatorState.copy(operand1 = "0", operator = operator)
        else calculatorState.copy(operator = operator)
    }
}