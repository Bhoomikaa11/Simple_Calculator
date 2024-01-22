package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {


    lateinit var n0: android.widget.Button
    lateinit var n1: android.widget.Button
    lateinit var n2: android.widget.Button
    lateinit var n3: android.widget.Button
    lateinit var n4: android.widget.Button
    lateinit var n5: android.widget.Button
    lateinit var n6: android.widget.Button
    lateinit var n7: android.widget.Button
    lateinit var n8: android.widget.Button
    lateinit var n9: android.widget.Button
    lateinit var dot:android.widget.Button
    lateinit var clear:android.widget.Button
    lateinit var divide:android.widget.Button
    lateinit var multiply:android.widget.Button
    lateinit var back:android.widget.Button
    lateinit var substarction:android.widget.Button
    lateinit var addition :android.widget.Button
    lateinit var answer:android.widget.Button
    lateinit var modulo:android.widget.Button
    lateinit var input:EditText
    lateinit var output:EditText
    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        n0 = findViewById(R.id.n0)
        n1 = findViewById(R.id.n1)
        n2 = findViewById(R.id.n2)
        n3 = findViewById(R.id.n3)
        n4 = findViewById(R.id.n4)
        n5 = findViewById(R.id.n5)
        n6 = findViewById(R.id.n6)
        n7 = findViewById(R.id.n7)
        n8 = findViewById(R.id.n8)
        n9 = findViewById(R.id.n9)
        dot = findViewById(R.id.dot)
        clear = findViewById(R.id.clear)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        back = findViewById(R.id.back)
        substarction = findViewById(R.id.substarction)
        addition = findViewById(R.id.addition)
        answer = findViewById(R.id.answer)
        modulo= findViewById(R.id.modulo)
        output=findViewById(R.id.output)
       input = findViewById(R.id.input)


         input.movementMethod=ScrollingMovementMethod()
         input.setActivated(true)
        input.setPressed(true)

        var text:String

       n0.setOnClickListener{
           text=input.text.toString()+"0"
           input.setText(text)
           result(text)
       }
        n1.setOnClickListener{
            text=input.text.toString()+"1"
            input.setText(text)
            result(text)
        }
        n2.setOnClickListener{
            text=input.text.toString()+"2"
            input.setText(text)
            result(text)
        }
        n3.setOnClickListener{
            text=input.text.toString()+"3"
            input.setText(text)
            result(text)
        }
        n4.setOnClickListener{
            text=input.text.toString()+"4"
            input.setText(text)
            result(text)
        }
        n5.setOnClickListener{
            text=input.text.toString()+"5"
            input.setText(text)
            result(text)
        }
        n6.setOnClickListener{
            text=input.text.toString()+"6"
            input.setText(text)
            result(text)
        }
        n7.setOnClickListener{
            text=input.text.toString()+"7"
            input.setText(text)
            result(text)
        }
        n8.setOnClickListener{
            text=input.text.toString()+"8"
            input.setText(text)
            result(text)
        }
        n9.setOnClickListener{
            text=input.text.toString()+"9"
            input.setText(text)
            result(text)
        }
        dot.setOnClickListener{
            text=input.text.toString()+"."
            input.setText(text)
            result(text)
        }
        addition.setOnClickListener{
            text=input.text.toString()+"+"
            input.setText(text)
            check+=1
        }
        substarction.setOnClickListener{
            text=input.text.toString()+"-"
            input.setText(text)
            check+=1
        }
        multiply.setOnClickListener{
            text=input.text.toString()+"*"
            input.setText(text)
            check+=1
        }
        divide.setOnClickListener{
            text=input.text.toString()+"÷"
            input.setText(text)
            check+=1
        }
        modulo.setOnClickListener{
            text=input.text.toString()+"%"
            input.setText(text)
            check+=1
        }
        answer.setOnClickListener{
            text=output.text.toString()
            input.setText(text)
            output.setText(null)
        }
        clear.setOnClickListener{
                input.setText(null)
            output.setText(null)
            }
        back.setOnClickListener{
            var b :String?=null
            if(input.text.length>0){
                val stringBuilder :StringBuilder = StringBuilder(input.text)
                val find = input.text.toString()
                val find2 = find.last()

                if(find2.equals('+')|| find2.equals('-')|| find2.equals('%')|| find2.equals('*')|| find2.equals('÷') ){
                    check--;
                }
                stringBuilder.deleteCharAt(input.text.length-1)
                b = stringBuilder.toString()
                input.setText(b)
                result(b)
            }
        }
    }

    private fun result(text: String) {
        val engine :ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result :Any=engine.eval(text)
            var mainr = result.toString()
            if(check==0)
            {
                output.setText(null)
            }
            else
            {
                output.setText(mainr)
            }
        }
        catch (e:ScriptException){
            Log.d("TAG","ERROR")
        }
    }
}