package com.example.agiledo.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.content.ContextCompat
import com.example.agiledo.R
import com.example.agiledo.databinding.FragmentDateBinding
import com.example.agiledo.ui.BaseFragment
import java.time.Month
import java.util.*

class DateFragment:BaseFragment<FragmentDateBinding>(),TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener

{
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDateBinding=FragmentDateBinding::inflate
    var month =0
    var year = 0
    var hour = 0
    var day = 0
    var minute = 0
    var savedDay =0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0
    val textdate = view?.findViewById<TextView>(R.id.text_date)




    override fun setup() {

    }

    override fun addCallbacks() {


         pickDate()



    }

       private fun getDateTimerCalender(){
        val cal:Calendar= Calendar.getInstance()
        day=cal.get(Calendar.DAY_OF_MONTH)
        month=cal.get(Calendar.MONTH)
        year=cal.get(Calendar.YEAR)
        hour=cal.get(Calendar.HOUR)
        minute=cal.get(Calendar.MINUTE)
    }
  private fun pickDate(){
       binding!!.bottom.setOnClickListener {

           getDateTimerCalender()
           DatePickerDialog(requireContext(), this, year, month, day).show()

  }


    }


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, daOfMonth: Int) {
        savedDay=daOfMonth
        savedMonth=month
        savedYear=year
        getDateTimerCalender()
        TimePickerDialog(requireContext(),this,hour,minute,true).show()
    }

    override val LOG_TAG: String="DATE_FRAGMENT"

    override fun onTimeSet(view: TimePicker?, hourofDay: Int, minute: Int) {
       savedHour=hourofDay
      savedMinute=minute
        textdate!!.text="$savedDay-$savedMonth-$savedYear\n Hour:$savedHour Miute:$savedMinute"





}}