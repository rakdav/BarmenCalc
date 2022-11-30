package com.example.barmencalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ClientActivity : AppCompatActivity() {
    private lateinit var  totalSum:TextView
    private lateinit var buttonOk:Button
    private lateinit var buttonCancel:Button
    private lateinit var message:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        totalSum=findViewById(R.id.totalSum)
        buttonOk=findViewById(R.id.buttonOk)
        buttonCancel=findViewById(R.id.buttonCancel)
        message=findViewById(R.id.message)
        var intent:Intent=getIntent()
        totalSum.text="%.2f".format(intent.getDoubleExtra("total_sum",0.0))
        buttonOk.setOnClickListener({
            var intent:Intent= Intent()
            intent.putExtra("message",message.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        })
        buttonCancel.setOnClickListener({
            setResult(RESULT_CANCELED)
            finish()
        })
    }
}