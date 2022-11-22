package com.example.barmencalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ClientActivity : AppCompatActivity() {
    private lateinit var  totalSum:TextView
    private lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        totalSum=findViewById(R.id.totalSum)
        button=findViewById(R.id.buttonOk)
        var intent:Intent=getIntent()
        totalSum.text="%.2f".format(intent.getDoubleExtra("total_sum",0.0))
        button.setOnClickListener({
            var intent:Intent= Intent()
            setResult(RESULT_OK)
            finish()
        })
    }
}