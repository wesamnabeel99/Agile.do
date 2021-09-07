package com.example.agiledo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import java.util.*

class date : AppCompatActivity() ,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
       var day=0
       var month=0
       var year=0
       var hour=0
       var minute=0
        var savedDay=0
       var savedMonth=0
       var savedYear=0
       var savedHour=0
       var savedMinute=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        pickDate()
    }

    private fun getDateTimeCalendar()
    {
        val cal:Calendar= Calendar.getInstance()
        day=cal.get(Calendar.DAY_OF_MONTH)
        month=cal.get(Calendar.MONTH)
        year=cal.get(Calendar.YEAR)
        hour=cal.get(Calendar.HOUR)
        minute=cal.get(Calendar.MINUTE)
    }
    private fun pickDate(){
      bottom.seOnClickListener{
            getDateTimeCalendar()
            DatePickerDialog(this,this,year,month,day).show()
        }

    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
      savedDay=day
        savedMonth=month
        savedYear=year
        getDateTimeCalendar()
           TimePickerDialog(this,this,hour,minute,true).show()
    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        savedHour=hour
        savedMinute=minute
       text_date.text="$savedDay-$savedMonth-$savedYear\n Hour:$savedHour minute:$savedMinute"
    }
}