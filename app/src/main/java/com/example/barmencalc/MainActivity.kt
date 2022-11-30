package com.example.barmencalc

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val TOTALSUM_EXTRA:String="total_sum"
    private lateinit var sum:EditText
    private lateinit var seek:SeekBar
    private lateinit var proc:TextView
    private lateinit var sumProc:TextView
    private lateinit var sumTotal:TextView
    private lateinit var send:Button
    private lateinit var result:TextView
    private var TotalSum:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sum=findViewById(R.id.price)
        seek=findViewById(R.id.seekBar)
        proc=findViewById(R.id.procent)
        sumProc=findViewById(R.id.procentMoney)
        sumTotal=findViewById(R.id.Total)
        send=findViewById(R.id.buttonSend)
        result=findViewById(R.id.result)
        sum.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().length!=0) {
                    var Sum: Int = s.toString().toInt()
                    var procent: Int = seek.progress
                    proc.text = procent.toString()
                    var calculator: Calculator = Calculator(procent, Sum)
                    sumProc.text = "%.2f".format(calculator.sumProcent())
                    sumTotal.text = "%.2f".format(calculator.sumTotal())
                    TotalSum = calculator.sumTotal()
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        seek.setOnSeekBarChangeListener(object :OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var Sum:Int=sum.text.toString().toInt()
                var procent:Int=progress
                proc.text=procent.toString()
                var calculator:Calculator= Calculator(procent,Sum)
                sumProc.text="%.2f".format(calculator.sumProcent())
                sumTotal.text="%.2f".format(calculator.sumTotal())
                TotalSum=calculator.sumTotal()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        send.setOnClickListener(
        {
            val intent:Intent= Intent(this,
                ClientActivity::class.java)
            intent.putExtra(TOTALSUM_EXTRA,TotalSum)
            getResult.launch(intent)
        })
    }
    private val getResult=registerForActivityResult(ActivityResultContracts.
    StartActivityForResult())
    {
        if(it.resultCode== Activity.RESULT_OK){
            var intent:Intent= it.data!!
            result.text=resources.getString(R.string.grate)+"\n"
                    intent.getStringExtra("message")
        }
    }
}