package com.example.agiledo.ui.adapters

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.agiledo.R
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.ItemTaskBinding
import com.example.agiledo.ui.TaskInteractionListener
import com.example.olympics.ui.TaskDiffUtil


class TaskAdapter(private var list: List<Task>, private val listener : TaskInteractionListener) : RecyclerView.Adapter<TaskAdapter.TaskHolder>(){
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
            deleteTask.setOnClickListener { listener.deleteTaskAt(position) }
            cardView.animation = AnimationUtils.loadAnimation(holder.binding.cardView.context,R.anim.anim_item)
        }
    }



    //region set data
    /**
     * this function will call in HomeFragment to replace the old list of task with the new list of task after addition or deletion
     * @param newList a List of objects of class Task representing the list to be replaced by
     * @return nothing
     * @author Anwar
     */
    fun setData(newList: List<Task>){
        val diffResult = DiffUtil.calculateDiff(TaskDiffUtil(list, newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }
    //endregion

    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemTaskBinding.bind(itemView)
    }

}