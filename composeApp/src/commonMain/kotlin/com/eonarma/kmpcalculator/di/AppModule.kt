package com.eonarma.kmpcalculator.di

import com.eonarma.kmpcalculator.domain.use_case.CalculateUseCase
import com.eonarma.kmpcalculator.domain.use_case.CalculatorUseCases
import com.eonarma.kmpcalculator.domain.use_case.ClearUseCase
import com.eonarma.kmpcalculator.domain.use_case.DecimalUseCase
import com.eonarma.kmpcalculator.domain.use_case.DeleteUseCase
import com.eonarma.kmpcalculator.domain.use_case.EnterNumberUseCase
import com.eonarma.kmpcalculator.domain.use_case.EnterOperatorUseCase
import com.eonarma.kmpcalculator.domain.use_case.InverseSignUseCase
import com.eonarma.kmpcalculator.presentation.viewmodel.CalculatorViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {

    // Provide individual use cases
    single { CalculateUseCase() }
    single { ClearUseCase() }
    single { DecimalUseCase() }
    single { DeleteUseCase() }
    single { EnterNumberUseCase() }
    single { EnterOperatorUseCase() }
    single { InverseSignUseCase() }

    // Provide the CalculatorUseCases data class
    single {
        CalculatorUseCases(
            calculate = get(),
            clear = get(),
            decimal = get(),
            delete = get(),
            enterNumber = get(),
            enterOperator = get(),
            inverseSign = get()
        )
    }

    // Provide the CalculatorViewModel
    viewModel { CalculatorViewModel(calculatorUseCases = get()) }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}