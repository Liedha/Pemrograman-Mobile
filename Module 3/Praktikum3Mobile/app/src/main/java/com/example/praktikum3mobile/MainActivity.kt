package com.example.praktikum3mobile

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var inputServiceCost: EditText
    private lateinit var radioGroupTipPercentage: RadioGroup
    private lateinit var switchRoundUp: Switch
    private lateinit var textTipResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputServiceCost = findViewById(R.id.input_service_cost)
        radioGroupTipPercentage = findViewById(R.id.radioGroup_tip_percentage)
        switchRoundUp = findViewById(R.id.checkbox_round_up)
        textTipResult = findViewById(R.id.text_tip_result)
        val buttonCalculateTip: Button = findViewById(R.id.button_calculate_tip)

        buttonCalculateTip.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val serviceCostString = inputServiceCost.text.toString()
        if (serviceCostString.isEmpty()) {
            textTipResult.text = "Please enter a cost of service."
            textTipResult.visibility = View.VISIBLE
            return
        }

        val serviceCost = serviceCostString.toDouble()
        val tipPercentage = when (radioGroupTipPercentage.checkedRadioButtonId) {
            R.id.radio_tip_20 -> 0.20
            R.id.radio_tip_18 -> 0.18
            R.id.radio_tip_15 -> 0.15
            else -> 0.0
        }

        var tipAmount = serviceCost * tipPercentage
        if (switchRoundUp.isChecked) {
            tipAmount = kotlin.math.ceil(tipAmount)
        }

        val currencyFormat = NumberFormat.getCurrencyInstance(Locale.US)
        val formattedTipAmount = currencyFormat.format(tipAmount)
        textTipResult.text = "Tip Amount: $formattedTipAmount"
        textTipResult.visibility = View.VISIBLE
    }
}
