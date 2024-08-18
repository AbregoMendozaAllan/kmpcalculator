package com.eonarma.kmpcalculator

import androidx.compose.runtime.Composable
import com.eonarma.kmpcalculator.domain.use_case.CalculatorUseCases
import com.eonarma.kmpcalculator.presentation.caulculator.Calculator
import com.eonarma.kmpcalculator.presentation.viewmodel.CalculatorViewModel
import com.eonarma.kmpcalculator.ui.CalculatorTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    CalculatorTheme(){
        KoinContext {
            Calculator()
        }
    }
}