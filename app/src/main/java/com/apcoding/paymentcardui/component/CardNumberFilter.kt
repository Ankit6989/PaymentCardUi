package com.apcoding.paymentcardui.component

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

private val cardNumberOffsetTranslation =object : OffsetMapping {

   // This function is used to map an offset in the original (unformatted) text to an offset in the transformed (formatted) text.
   // It takes an offset as input, which represents the position of the cursor in the original text.
   // The function applies logic to adjust this offset for the formatting of a credit card number.
   // The logic adds extra positions (offsets) to account for spaces that are inserted for formatting.
    override fun originalToTransformed(offset: Int): Int {
        if (offset <= 3) return offset
        if (offset <= 7) return offset + 1
        if (offset <= 11) return offset + 2
        if (offset <= 16) return offset + 3
        return 19
    }
    // This function is used to map an offset in the transformed (formatted) text back to an offset in the original (unformatted) text.
    // It takes an offset as input, which represents the position of the cursor in the transformed text.
    // The function applies logic to adjust this offset for the formatting of a credit card number.
    // The logic subtracts positions (offsets) to account for spaces that were inserted for formatting when moving from transformed to original text.

    override fun transformedToOriginal(offset: Int): Int {
        if (offset <= 4) return offset
        if (offset <= 9) return offset - 1
        if (offset <= 14) return offset - 2
        if (offset <= 19) return offset - 3
        return 16
    }
}

val CardNumberFilter = VisualTransformation { text ->
    val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text // Limiting to 16 characters
    //It trims the input text to a maximum length of 16 characters. This ensures that the credit card number doesn't exceed the expected length.
    var space = ""
    for (i in trimmed.indices) {
        space += trimmed[i]
        if (i % 4 == 3 && i != 15) space += " "
    }
    TransformedText(AnnotatedString(space), cardNumberOffsetTranslation)
}

