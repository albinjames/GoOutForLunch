package com.diegomfv.gooutforlunch.utils.extensions


fun Float.floatTo1Decimal() = this.floatToAmountOfDecimals(1)

fun Float.floatTo2Decimals() = this.floatToAmountOfDecimals(2)

fun Float.floatTo3Decimals() = this.floatToAmountOfDecimals(3)

fun Float.floatToAmountOfDecimals(amountOfDecimals: Int): Float {
    val number: Double = this.toDouble()
    val number3digits: Double = Math.round(number * 1000.0) / 1000.0
    val number2digits: Double = Math.round(number3digits * 100.0) / 100.0
    val number1digit: Double = Math.round(number2digits * 10.0) / 10.0

    return when (amountOfDecimals) {
        1 -> {
            number1digit.toFloat()
        }
        2 -> {
            number2digits.toFloat()
        }
        3 -> {
            number3digits.toFloat()
        }
        else -> {
            this
        }
    }
}

fun String.compareIgnoreCase(stringToCompare: String) = this.equals(stringToCompare, true)

fun String?.orEmpty () = this ?: ""

fun Float.stringFormatTo2Decimals () = String.format("%.2f", this.floatTo2Decimals()).replace(',','.')
fun Float.stringFormatTo4Decimals () = String.format("%.4f", this).replace(',','.')

fun MutableMap<String, String>.trimAll() : MutableMap<String, String> {
    val trimmedMap = mutableMapOf<String,String>()
    this.forEach { (k, v) ->
        trimmedMap[k] = v.trim()
    }
    return trimmedMap
}

fun <T> List<T>.toArrayList () : ArrayList<T> = ArrayList(this)
