package me.syari.android.calculator

class FormulaBuilder {
    private val stringBuilder = StringBuilder()

    fun isLast(element: FormulaElement): Boolean {
        return stringBuilder.matches("^.*${element.regex}$".toRegex())
    }

    fun append(char: Char) {
        stringBuilder.append(char)
    }

    override fun toString(): String {
        return stringBuilder.toString()
    }
}