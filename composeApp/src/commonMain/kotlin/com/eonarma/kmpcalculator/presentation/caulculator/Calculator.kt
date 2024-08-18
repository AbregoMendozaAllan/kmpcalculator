package com.eonarma.kmpcalculator.presentation.caulculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eonarma.kmpcalculator.domain.model.Action
import com.eonarma.kmpcalculator.domain.model.Operation
import com.eonarma.kmpcalculator.presentation.caulculator.components.CalculatorButton
import com.eonarma.kmpcalculator.presentation.viewmodel.CalculatorViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun Calculator() {
    val viewModel = koinViewModel<CalculatorViewModel>()
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = state.operand1 + (state.operator?.operator ?: "") + state.operand2,
                fontSize = 50.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Row() {
            CalculatorButton(
                text = "AC",
                onClick = { viewModel.onAction(Action.Clear) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 165, green = 165, blue = 165)
            )
            CalculatorButton(
                text = "DEL",
                onClick = { viewModel.onAction(Action.Delete) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 165, green = 165, blue = 165)
            )
            CalculatorButton(
                text = "+/-",
                onClick = { viewModel.onAction(Action.InverseSign) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 165, green = 165, blue = 165)
            )
            CalculatorButton(
                text = "÷",
                onClick = { viewModel.onAction(Action.EnterOperator(Operation.Division)) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 251, green = 156, blue = 9)
            )
        }
        Row() {
            CalculatorButton(
                text = "7",
                onClick = { viewModel.onAction(Action.EnterNumber("7")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "8",
                onClick = { viewModel.onAction(Action.EnterNumber("8")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "9",
                onClick = { viewModel.onAction(Action.EnterNumber("9")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "x",
                onClick = { viewModel.onAction(Action.EnterOperator(Operation.Multiplication)) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 251, green = 156, blue = 9)
            )
        }
        Row() {
            CalculatorButton(
                text = "4",
                onClick = { viewModel.onAction(Action.EnterNumber("4")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "5",
                onClick = { viewModel.onAction(Action.EnterNumber("5")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "6",
                onClick = { viewModel.onAction(Action.EnterNumber("6")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "-",
                onClick = { viewModel.onAction(Action.EnterOperator(Operation.Subtraction)) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 251, green = 156, blue = 9)
            )
        }
        Row() {
            CalculatorButton(
                text = "1",
                onClick = { viewModel.onAction(Action.EnterNumber("1")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "2",
                onClick = { viewModel.onAction(Action.EnterNumber("2")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "3",
                onClick = { viewModel.onAction(Action.EnterNumber("3")) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "+",
                onClick = { viewModel.onAction(Action.EnterOperator(Operation.Addition)) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 251, green = 156, blue = 9)
            )
        }
        Row() {
            CalculatorButton(
                text = "0",
                onClick = { viewModel.onAction(Action.EnterNumber("0")) },
                modifier = Modifier
                    .weight(2f)
            )
            CalculatorButton(
                text = ".",
                onClick = { viewModel.onAction(Action.Decimal) },
                modifier = Modifier
                    .weight(1f)
            )
            CalculatorButton(
                text = "=",
                onClick = { viewModel.onAction(Action.Equals) },
                modifier = Modifier
                    .weight(1f),
                color = Color(red = 251, green = 156, blue = 9)
            )
        }
    }
}