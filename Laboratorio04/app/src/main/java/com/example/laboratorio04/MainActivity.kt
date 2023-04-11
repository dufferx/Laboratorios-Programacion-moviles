package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var inputName:TextInputEditText
    private lateinit var inputEmail:TextInputEditText
    private lateinit var inputPhone:TextInputEditText
    private lateinit var saveButton: Button






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    private fun bind(){
        inputName = findViewById(R.id.name_input_text)
        inputEmail = findViewById(R.id.email_input_text)
        inputPhone = findViewById(R.id.phone_input_text)
        saveButton = findViewById(R.id.save_button)
    }

    private fun addListener(){
        saveButton.setOnClickListener {
            var intent = Intent(this,MainActivity2::class.java)
            intent.putExtra(NAME_INPUT,inputName.text.toString())
            intent.putExtra(EMAIL_INPUT,inputEmail.text.toString())
            intent.putExtra(PHONE_INPUT,inputPhone.text.toString())
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            putString(NAME_INPUT, inputName.text.toString())
            putString(EMAIL_INPUT, inputEmail.text.toString())
            putString(PHONE_INPUT, inputPhone.text.toString())

        }
    }

    companion object{
        const val NAME_INPUT = "NAME_INPUT"
        const val EMAIL_INPUT = "EMAIL_INPUT"
        const val PHONE_INPUT = "PHONE_INPUT"
    }
}