package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    //UI ELEMENTS

    private lateinit var shareButton: Button
    private lateinit var nameResult: TextView
    private lateinit var emailResult: TextView
    private lateinit var phoneResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        bind()
        addListener()

        if (intent != null){
            intent.extras?.apply {
                val nameResult = getString(MainActivity.NAME_INPUT)
                val emailResult = getString(MainActivity.EMAIL_INPUT)
                val phoneResult = getString(MainActivity.PHONE_INPUT)


                findViewById<TextView>(R.id.name_result_text_view).apply {
                    text = nameResult
                }

                findViewById<TextView>(R.id.email_result_text_view).apply {
                    text = emailResult
                }
                findViewById<TextView>(R.id.phone_result_text_view).apply {
                    text = phoneResult
                }
            }
        }
    }

    private fun bind(){
        shareButton = findViewById(R.id.share_button)
        nameResult = findViewById(R.id.name_result_text_view)
        emailResult = findViewById(R.id.email_result_text_view)
        phoneResult = findViewById(R.id.phone_result_text_view)

    }

    private fun addListener(){
        shareButton.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nombre: ${nameResult.text.toString()} Correo: ${emailResult.text.toString()} Telefono: ${phoneResult.text.toString()}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)


        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            putString(MainActivity.NAME_INPUT, nameResult.text.toString())
            putString(MainActivity.EMAIL_INPUT, emailResult.text.toString())
            putString(MainActivity.PHONE_INPUT, phoneResult.text.toString())

        }
    }

    companion object{
        const val NAME_INPUT = "NAME_INPUT"
        const val EMAIL_INPUT = "EMAIL_INPUT"
        const val PHONE_INPUT = "PHONE_INPUT"
    }


}