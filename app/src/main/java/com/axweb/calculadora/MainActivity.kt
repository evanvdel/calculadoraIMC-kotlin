package com.axweb.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        val editWeight = findViewById<EditText>(R.id.edit_weight)
        val seekbarHeight = findViewById<SeekBar>(R.id.seekbar_height)
        val buttonClear = findViewById<Button>(R.id.button_clear)
        val buttonCalculate = findViewById<Button>(R.id.button_calculate)
        val textHeightValue = findViewById<TextView>(R.id.text_height_value)

        seekbarHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
               textHeightValue.text = "$progress cm"
                textHeightValue.visibility = View.VISIBLE
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        buttonCalculate.setOnClickListener {

        }

        buttonClear.setOnClickListener {
            editWeight.setText("")
            seekbarHeight.progress = 0
            textHeightValue.visibility = View.GONE

        }
    }
}