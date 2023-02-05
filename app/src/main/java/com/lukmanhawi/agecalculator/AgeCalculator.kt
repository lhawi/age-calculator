package com.lukmanhawi.agecalculator

import java.text.SimpleDateFormat
import java.util.*

class AgeCalculator {
    fun calculateAgeInMinutes(selectedDate: String): Long {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val theDate = sdf.parse(selectedDate)
        theDate?.let {
            val selectedDateInMinutes = theDate.time / 60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            currentDate?.let {
                val currentDateInMinutes = currentDate.time / 60000

                return currentDateInMinutes - selectedDateInMinutes
            }
        }
        return 0
    }
}