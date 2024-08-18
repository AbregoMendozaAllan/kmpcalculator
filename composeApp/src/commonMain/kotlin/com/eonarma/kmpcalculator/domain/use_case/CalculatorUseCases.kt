package com.eonarma.kmpcalculator.domain.use_case

data class CalculatorUseCases(
    val calculate: CalculateUseCase,
    val clear: ClearUseCase,
    val decimal: DecimalUseCase,
    val delete: DeleteUseCase,
    val enterNumber: EnterNumberUseCase,
    val enterOperator: EnterOperatorUseCase,
    val inverseSign: InverseSignUseCase
)