package com.example.agiledo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.FragmentHomeBinding
import com.example.agiledo.ui.adapters.TaskAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "HOME_FRAGMENT"

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate

      override fun setup() {
        val adapter = TaskAdapter(DataManager.listOfTasks)
        binding?.taskRecyclerView?.adapter =adapter

          /**
           * @param thisIteman an val to bind this item
           * @param itemTouchHelper an val to add swipe to dismiss *
           * @author Akram
           **/
          val thisItem = binding?.taskRecyclerView
          val itemTouchHelper = ItemTouchHelper (SwipeToDelete(adapter))
          itemTouchHelper.attachToRecyclerView(thisItem)

          val cardView = binding?.taskRecyclerView



      }

    override fun addCallbacks() {
        //TODO : "Not Yet Implemented"
    }



}