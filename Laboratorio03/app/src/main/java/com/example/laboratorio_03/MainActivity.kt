package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //UI ELEMENTS

    private lateinit var displayTotal: TextView
    private lateinit var fiveCents : ImageView
    private lateinit var tenCents : ImageView
    private lateinit var oneQuarter : ImageView
    private lateinit var oneDollar : ImageView

    //DATA ELEMENTS
    private var total = 0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    private fun bind() {
        displayTotal =findViewById(R.id.total_text_view)
        fiveCents =findViewById(R.id.five_cents_image_view)
        tenCents =findViewById(R.id.ten_cents_image_view)
        oneQuarter = findViewById(R.id.one_quarter_image_view)
        oneDollar = findViewById(R.id.one_dollar_image_view)

    }

    private fun addListener(){
        fiveCents.setOnClickListener {
            total += 0.050
            displayTotal.setText(String.format("%.2f",total))
        }

        tenCents.setOnClickListener {
            total += 0.10
            displayTotal.setText(String.format("%.2f",total))
        }

        oneQuarter.setOnClickListener {
            total += 0.250
            displayTotal.text = total.toString()
        }

        oneDollar.setOnClickListener {
            total += 1
            displayTotal.text = total.toString()
        }


    }
}