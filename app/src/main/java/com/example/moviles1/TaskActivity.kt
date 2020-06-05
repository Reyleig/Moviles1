package com.example.moviles1

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.view.*
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.time.MonthDay
import java.time.Year
import java.util.*

class TaskActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
    }
    fun onCreateTask(view: View){
        val intento = Intent(this,TaskActivity::class.java)
        intento.apply{
            putExtra(
                Constants.taskTitle
                edtTxtTarea!!.text.toString()
            )
            putExtra(
                Constants.taskDate
                        btnDate.text.toString()
            )
            putExtra(
                Constants.taskTime
                        btnTime.text.toString()
            )
        }
        setResult(Activity.RESULT_OK,intento)
        finish()
    }
    fun onSelectDate(view: View){
        DatePickerFragment().show(supportFragmentManager,"datePicker")
    }
    fun onSelectTime (view: View){
        TimePickerFragment().show(supportFragmentManager,"timePicker")
    }
}
class  TimePickerFragment:DialogFragment(),TimePickerFragment.OnTimeSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c=Calendar.getInstance()
        val hour=c.get(Calendar.HOUR_OF_DAY)
        val minute=c.get(Calendar.MINUTE)

        return TimePickerDialog(activity, this ,hour,minute, DateFormat.(activity))
    }
     override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute:Int){
        this.activity?.findViewById<Button>(R.id.btnTime)?.text=""+hourOfDay+":"+minute
    }
}
class DatePickerFragment:DialogFragment,DatePickerFragment.OnDateSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity,this,year,month,day)
    }
    override fun onDateSet(view: DatePicker, year: Int, month, Int, day:Int){
        this.activity?.findViewById<Button>(R.id.btnDate)?.text=""+(month+1)+"/"+day+"/"+year
    }
}


