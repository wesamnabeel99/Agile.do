package com.example.agiledo.ui

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.agiledo.data.DataManager
import com.example.agiledo.ui.adapters.TaskAdapter

class SwipeToDelete(var adapter: TaskAdapter): ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val pos = viewHolder.adapterPosition
        DataManager.deleteTaskAt(pos)
        adapter.setData(DataManager.tasks)
    }


}