package me.syari.android.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val formulaBuilder = FormulaBuilder()

    private val resultTextView by lazy { findViewById<TextView>(R.id.text_result) }

    private fun appendFormula(char: Char) {
        formulaBuilder.append(char)
        resultTextView.text = formulaBuilder.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapOf(
            R.id.button_0 to '0',
            R.id.button_1 to '1',
            R.id.button_2 to '2',
            R.id.button_3 to '3',
            R.id.button_4 to '4',
            R.id.button_5 to '5',
            R.id.button_6 to '6',
            R.id.button_7 to '7',
            R.id.button_8 to '8',
            R.id.button_9 to '9'
        ).forEach { (id, char) ->
            findViewById<Button>(id).setOnClickListener {
                appendFormula(char)
            }
        }
        mapOf(
            R.id.button_plus to '+',
            R.id.button_minus to '-',
            R.id.button_multiply to '*',
            R.id.button_divide to '/'
        ).forEach { (id, char) ->
            findViewById<Button>(id).setOnClickListener {
                if (formulaBuilder.isLast(FormulaElement.Number)) {
                    appendFormula(char)
                }
            }
        }
        findViewById<Button>(R.id.button_point).setOnClickListener {
            if (formulaBuilder.toString().lastOrNull() != '.') {
                appendFormula('.')
            }
        }
    }
}