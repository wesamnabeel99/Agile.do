package com.example.agiledo.ui.adapters

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agiledo.R
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.ItemTaskBinding


class TaskAdapter(var list: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TaskHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val currentItem=list[position]
        holder.binding.apply {
            taskTitle.text = currentItem.taskName
            taskDescription.text = currentItem.taskDescription
            taskStartDate.text = currentItem.taskStartDate
            taskDueDate.text = currentItem.taskDueDate
            taskAssignedTo.text= currentItem.taskAssignedTo
        }
    }
    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemTaskBinding.bind(itemView)
    }
}