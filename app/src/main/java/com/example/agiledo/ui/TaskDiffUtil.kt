package com.example.olympics.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.agiledo.data.domain.Task

class TaskDiffUtil(val mOldList : List<Task>, val mNewList : List<Task>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = mOldList.size

    override fun getNewListSize(): Int = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not Yet Implemented")
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }


}