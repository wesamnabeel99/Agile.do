package com.example.agiledo.utils

import java.util.*

class Date {
    /**
     * this function will return the current time in the format (year-month-day , hour:minute)
     * @param nothng
     * @return a string represinting the tiem in the format (year-month-day , hour:minute)
     * @author Hawraa Khudair, Wesam N. Shawqi
     */
     fun getDateTimerCalender():String{
        val calendar= Calendar.getInstance()
        val currentDay=calendar.get(Calendar.DAY_OF_MONTH)
        val currentMonth=calendar.get(Calendar.MONTH) // Android SDK, months are indexed starting at 0.
        val currentYear=calendar.get(Calendar.YEAR)
        val currentHour=calendar.get(Calendar.HOUR)
        val currentMinute=calendar.get(Calendar.MINUTE)
        return "$currentYear-$currentMonth-$currentDay , $currentHour:$currentMinute"
    }

}