package com.example.agiledo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.agiledo.data.DataManager
import com.example.agiledo.databinding.FragmentStatsBinding
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

class StatsFragment : BaseFragment<FragmentStatsBinding>() {
    override val LOG_TAG: String = "STATISTIC_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStatsBinding = FragmentStatsBinding ::inflate

    override fun setup() {
        setBarChartValues()
    }

    override fun addCallbacks() {
    }

    /**
     * set chart data Values
     * @param nothing
     * @return nothing
     * @author Anwar
     */
    private fun setBarChartValues(){


        // X values
        val taskStatus = ArrayList<String>()
        taskStatus.add("In Backlog")
        taskStatus.add("In Progress")
        taskStatus.add("Done")

        // Y values
        val noOfTasks = ArrayList<BarEntry>()
        val value = DataManager.listOfTasks.size
        noOfTasks.add(BarEntry(value.toFloat(),0))
        noOfTasks.add(BarEntry(5.7f, 1))
        noOfTasks.add(BarEntry(1.5f, 2))

        //private fun
        val barDataSet = BarDataSet(noOfTasks, "Task Status")
        val colors = ColorTemplate.VORDIPLOM_COLORS + ColorTemplate.VORDIPLOM_COLORS + ColorTemplate.VORDIPLOM_COLORS
        barDataSet.colors = colors.toList()

        val barData = BarData (taskStatus , barDataSet)

        binding?.barChart!!.apply{
            data = barData
            invalidate()
        }

        configureChartAppearance()

    }


    private fun configureChartAppearance(){
        binding?.barChart!!.apply{
            setDrawGridBackground(false)
            setDrawBarShadow(false)
            setDrawValueAboveBar(true)
            axisLeft.setDrawGridLines(false)
            axisRight.setDrawGridLines(false)
            setMaxVisibleValueCount(3)
            setDescription(" ")
            setPinchZoom(false)
            animateXY(2000,2000)
        }
    }

}