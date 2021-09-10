package com.example.agiledo.ui

import android.app.Activity
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.agiledo.R
import com.example.agiledo.data.DataManager
import com.example.agiledo.databinding.FragmentStatusBinding
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

class StatusFragment : BaseFragment<FragmentStatusBinding>() {
    override val LOG_TAG: String = "STATISTIC_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStatusBinding = FragmentStatusBinding ::inflate

    override fun setup() {
        setBarChartValues()
    }

    override fun addCallbacks() {
        binding?.apply {
            val homeFragment = HomeFragment()
            openBoardButton.setOnClickListener {
            addFragment(homeFragment)
            }
        }
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
        val numberOfTasks = ArrayList<BarEntry>()
        val listOfInBackingSize = DataManager.listOfTasks.size
        numberOfTasks.add(BarEntry(listOfInBackingSize.toFloat(),0))
        numberOfTasks.add(BarEntry(5.7f, 1))
        numberOfTasks.add(BarEntry(1.5f, 2))

        //private fun
        val barDataSet = BarDataSet(numberOfTasks, "Task Status")
        val colors = ColorTemplate.VORDIPLOM_COLORS + ColorTemplate.VORDIPLOM_COLORS + ColorTemplate.VORDIPLOM_COLORS
        barDataSet.colors = colors.toList()

        val barData = BarData (taskStatus , barDataSet)

        binding?.barChart?.apply{
            data = barData
            invalidate()
        }

        configureChartAppearance()

    }


    private fun configureChartAppearance(){
        binding?.barChart?.apply{
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
    private fun addFragment(fragment: Fragment) {
        val transaction = (activity as HomeActivity).supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }

}