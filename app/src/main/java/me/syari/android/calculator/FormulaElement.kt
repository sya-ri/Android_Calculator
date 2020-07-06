package me.syari.android.calculator

enum class FormulaElement(val regex: String) {
    Number("\\d+(?:\\.\\d+)?"),
    Operator("[+\\-*/]")
}