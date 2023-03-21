package com.example.laboratorio02

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    //UI elements
    private lateinit var addWeight: EditText
    private lateinit var addHeight: EditText
    private lateinit var calculateBmi : Button
    private lateinit var displayBmi: TextView
    private lateinit var displayWeightClass: TextView
    private lateinit var displayIbmRange: TextView

    //data element
    private var ibm = 0.0
    private var ibmrounded = 0.0
    private var weight = 0
    private var height = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        addListener()
    }

    private fun bind(){
        addWeight = findViewById(R.id.add_weight_edit_text)
        addHeight = findViewById(R.id.add_height_edit_text)
        calculateBmi = findViewById(R.id.calculate_bmi_button)
        displayBmi = findViewById(R.id.display_bmi_text_view)
        displayWeightClass = findViewById(R.id.weight_class_text_view)
        displayIbmRange = findViewById(R.id.ibm_range_text_view)
    }

    private fun addListener(){
        calculateBmi.setOnClickListener {
            weight = addWeight.text.toString().toInt()
            height = addHeight.text.toString().toInt()


            

            ibm = weight.toDouble()/Math.pow(height/100.toDouble(),2.0)
            ibmrounded = (Math.round(ibm*100.0)/100.0)



            displayBmi.text = ibmrounded.toString()



            when {
                ibmrounded < 18.45 -> {
                    displayWeightClass.text = getResources().getText(R.string.Underweight)
                    displayWeightClass.setTextColor(getResources().getColor(R.color.under_weight, null))
                    displayIbmRange.text = getResources().getText(R.string.Range)
                }
                ibmrounded in 18.5..24.99-> {
                    displayWeightClass.text = getResources().getText(R.string.Healthy)
                    displayWeightClass.setTextColor(getResources().getColor(R.color.normal_weight, null))
                    displayIbmRange.text = getResources().getText(R.string.Range)

                }
                ibmrounded in 25.0..29.99-> {
                    displayWeightClass.text = getResources().getText(R.string.Overweight)
                    displayWeightClass.setTextColor(getResources().getColor(R.color.over_weight, null))
                    displayIbmRange.text = getResources().getText(R.string.Range)

                }

                ibmrounded > 30 -> {
                    displayWeightClass.text = getResources().getText(R.string.Obese)
                    displayWeightClass.setTextColor(getResources().getColor(R.color.obese, null))
                    displayIbmRange.text = getResources().getText(R.string.Range)

                }


            }
        }
    }
}