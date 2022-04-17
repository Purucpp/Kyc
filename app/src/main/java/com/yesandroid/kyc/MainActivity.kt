package com.yesandroid.kyc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var pan: TextInputEditText
    lateinit var dd: TextInputEditText
    lateinit var mm: TextInputEditText
    lateinit var yyyy: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<Button>(R.id.next)
        pan=findViewById<TextInputEditText>(R.id.pan)
        dd=findViewById<TextInputEditText>(R.id.dd)
        mm=findViewById<TextInputEditText>(R.id.mm)
        yyyy=findViewById<TextInputEditText>(R.id.yyyy)

        button.setOnClickListener{
            Toast.makeText(applicationContext, "Details Submitted Successfully", Toast.LENGTH_LONG).show()
        }


        pan.addTextChangedListener { charSequence  ->
            try {
                if (charSequence != null) {
                    if(charSequence.length==10) {
                        if(validate())
                        {
                            button.isEnabled=true
                            Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show()
                        }

                    }
                }
            } catch (error: Throwable) {

            }
        }


        dd.addTextChangedListener { charSequence  ->
            try {
                if (charSequence != null) {
                    if(charSequence.length==2) {
                        var d: Int= charSequence.toString().toInt();

                        if(d > 31 || d<1)
                        {
                            Toast.makeText(applicationContext, "Date is Invalid", Toast.LENGTH_LONG).show()
                        }
                       else if(validate())
                        {
                            button.isEnabled=true
                            Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show()
                        }

                        }

                }
            } catch (error: Throwable) {

            }
        }

        mm.addTextChangedListener { charSequence  ->
            try {
                if (charSequence != null) {
                    if(charSequence.length==2) {

                        var m: Int= charSequence.toString().toInt();

                        if(m > 12 || m<1)
                        {
                            Toast.makeText(applicationContext, "Month is Invalid", Toast.LENGTH_LONG).show()
                        }
                       else if(validate())
                        {
                            button.isEnabled=true
                            Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show()
                        }

                    }
                }
            } catch (error: Throwable) {

            }
        }

        yyyy.addTextChangedListener { charSequence  ->
            try {
                if (charSequence != null) {
                    if(charSequence.length==4) {

                        var y: Int= charSequence.toString().toInt();

                        if(y>2005)
                        {
                            Toast.makeText(applicationContext, "Age is less then 18 year", Toast.LENGTH_LONG).show()
                        }

                       else if(validate())
                        {
                            button.isEnabled=true
                            Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show()
                        }

                    }
                }
            } catch (error: Throwable) {

            }
        }


    }

   /* fun validate(a: Int, b: Int): Boolean {
        return false
    } */

    fun validate(): Boolean {

        if((pan.text)!!.length!=10)
        {
            return false
        }
        else if((dd.text)!!.length!=2)
        {
            return false
        }
        else if((mm.text)!!.length!=2)
        {
            return false
        }
        else if((yyyy.text)!!.length!=4)
        {
            return false
        }

        return true
    }


   /* fun test(){
        if((pan.text)!!.length==10)
        {
            button.isEnabled=true
        }

    } */

//    val txt = "82389235"
//    val numbers = txt.map { it.toString().toInt() }
}