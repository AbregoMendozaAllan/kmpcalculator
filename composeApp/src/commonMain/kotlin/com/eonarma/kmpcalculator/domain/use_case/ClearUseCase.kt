package com.eonarma.kmpcalculator.domain.use_case

import com.eonarma.kmpcalculator.domain.model.CalculatorState

class ClearUseCase {
    fun execute(calculatorState: CalculatorState): CalculatorState {
        return CalculatorState()
    }
}