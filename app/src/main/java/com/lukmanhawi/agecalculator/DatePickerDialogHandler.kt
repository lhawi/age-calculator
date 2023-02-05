package com.lukmanhawi.agecalculator

import android.app.DatePickerDialog
import android.content.Context
import java.util.*

class DatePickerDialogHandler(
    private val context: Context,
    private val onDateSelected: (year: Int, month: Int, dayOfMonth: Int) -> Unit
) {
    fun showDatePickerDialog() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                onDateSelected(selectedYear, selectedMonth, selectedDayOfMonth)
            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}