package com.example.olympics.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.agiledo.data.domain.Task

class TaskDiffUtil(val tOldList : List<Task>, val tNewList : List<Task>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = tOldList.size

    override fun getNewListSize(): Int = tNewList.size

    //region areItemsTheSame
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                tOldList[oldItemPosition].taskName == tNewList[newItemPosition].taskName
                        && tOldList[oldItemPosition].taskDescription == tNewList[newItemPosition].taskDescription
                )
    }
    //endregion
    //region areContentsTheSame
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return false
    }
    //endregion


}