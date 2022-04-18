package com.byteme.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        solution.setText("")

    }

    fun btnEvent(view:View){
        val btnSelect = view as AppCompatButton
        var value:String = solution.text.toString()
        val btnClickValue = when(btnSelect.id){
            R.id.btn0->"0"
            R.id.btn1->"1"
            R.id.btn2->"2"
            R.id.btn3->"3"
            R.id.btn4->"4"
            R.id.btn5->"5"
            R.id.btn6->"6"
            R.id.btn7->"7"
            R.id.btn8->"8"
            R.id.btn9->"9"
            R.id.btnDot->"."
            else->""
        }
        value += btnClickValue
        solution.setText(value)

    }
    var operation = ""
    var firstValue = ""
    fun btnOperationEvent(view:View){
        val btnSelect = view as AppCompatButton



        operation  = when(btnSelect.id){
            R.id.btnModulo->"%"
            R.id.btnAdd->"+"
            R.id.btnSub->"-"
            R.id.btnDivide->"/"
            R.id.btnMultiply->"*"
            else->""
        }
        firstValue = solution.text.toString()
        solution.setText("")

        if (btnSelect.id == R.id.btnFact)
            solution.setText(fact(firstValue.toInt()).toString())
    }

    //Factorial function
    private fun fact(num:Int):Int{
        if (num == 1)
            return 1
        return num * fact(num-1)
    }

    fun btnEqualEvent(view:View){
        val secondValue = solution.text.toString()
        var finalValue:Double = 0.0

        when(operation){
            "+"->{finalValue = firstValue.toDouble() + secondValue.toDouble()}
            "-"->{finalValue = firstValue.toDouble() - secondValue.toDouble()}
            "*"->{finalValue = firstValue.toDouble() * secondValue.toDouble()}
            "/"->{finalValue = firstValue.toDouble() / secondValue.toDouble()}
            "%"->{finalValue = firstValue.toDouble() % secondValue.toDouble()}
        }

        var str = finalValue.toString()
        val afterDot = str.substringAfter('.')
        if (afterDot == "0")
            str = str.substringBefore('.')
        solution.setText(str)
    }

    fun btnAcEvent(view:View){
        solution.setText("")
    }
}