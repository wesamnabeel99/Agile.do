package com.example.agiledo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aghajari.emojiview.view.AXSingleEmojiView
import com.example.agiledo.data.DataManager
import com.example.agiledo.databinding.FragmentHomeBinding
import com.example.agiledo.ui.adapters.TaskAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "HOME_FRAGMENT"

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate

      override fun setup() {
        val adapter = TaskAdapter(DataManager.listOfTasks)
        binding?.taskRecyclerView?.adapter =adapter
    }

    override fun addCallbacks() {
    }
}