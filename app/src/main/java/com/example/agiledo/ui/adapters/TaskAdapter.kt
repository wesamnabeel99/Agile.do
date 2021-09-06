package com.example.agiledo.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.agiledo.R
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.ItemTaskBinding


class TaskAdapter(var list: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TaskHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        var currentItem = list[position]
        holder.binding.apply {
            taskTitle.text = currentItem.taskName
            taskDescription.text = currentItem.taskDescription
            taskStartDate.text = currentItem.taskStartDate
            taskDueDate.text = currentItem.taskDueDate
            taskAssignedTo.text= currentItem.taskAssignedTo
            cardView.animation = AnimationUtils.loadAnimation(holder.binding.cardView.context,R.anim.anim_item)
        }
    }

    fun deleteItem(pos: Int) {
        DataManager.listOfTasks.removeAt(pos)
        notifyDataSetChanged()
    }

    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemTaskBinding.bind(itemView)
    }

}