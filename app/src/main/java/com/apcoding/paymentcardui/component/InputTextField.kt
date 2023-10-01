package com.apcoding.paymentcardui.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    textFieldValue: TextFieldValue,
    label: String,
    onTextChanged: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    textStyle: TextStyle = typography.bodyMedium.copy(color = Color.Black),
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = { onTextChanged(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        textStyle = textStyle,
        maxLines = 1,
        singleLine = true,
        label = {
            Text(
                text = label,
                style = typography.bodyMedium
            )
        },
        modifier = modifier,
        visualTransformation = visualTransformation
    )
}

@Preview(showBackground = true)
@Composable
fun InputTextFieldPreview() {
    InputTextField(
        textFieldValue = TextFieldValue(),
        label = "Card Number",
        onTextChanged = { },
        modifier = Modifier,
        visualTransformation = VisualTransformation.None
    )
}