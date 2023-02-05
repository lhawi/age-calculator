package com.lukmanhawi.agecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    private var tvAgeInMinutes: TextView? = null
    private val datePickerDialogHandler =
        DatePickerDialogHandler(this) { selectedYear, selectedMonth, selectedDayOfMonth ->
            val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
            tvSelectedDate?.text = selectedDate
            tvAgeInMinutes?.text = AgeCalculator().calculateAgeInMinutes(selectedDate).toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)

        btnDatePicker.setOnClickListener {
            datePickerDialogHandler.showDatePickerDialog()
        }
    }
}