package com.example.agiledo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.FragmentHomeBinding
import com.example.agiledo.ui.adapters.TaskAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() , TaskInteractionListener {
    //region initilize variables
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate
    lateinit var adapter : TaskAdapter
    //endregion

    //region setup
    override fun setup() {
        adapter = TaskAdapter(DataManager.listOfTasks, this)
        binding?.taskRecyclerView?.adapter =adapter
    }
    //endregion
    //region  addCallbacks
    override fun addCallbacks() {
        binding?.addTask?.setOnClickListener {
            addNewTask()
        }
    }
    //endregion

    //region addNewTask
    /**
     * this function add new task of type object of class Task to the list of task
     * @param nothing
     * @return nothing
     * @author Anwar
     */
    private fun addNewTask() {
        val newTask = Task(
            taskName = binding?.taskName?.text.toString(),
            taskDescription = binding?.taskDescription?.text.toString(),
            taskStartDate = binding?.startDate?.text.toString(),
            taskDueDate = binding?.dueDate?.text.toString(),
            taskAssignedTo = binding?.personName?.text.toString()
        )
        DataManager.addTask(newTask)
        adapter.setData(DataManager.tasks)
    }
    //endregion

    //region deleteTaskAt
    /**
     * this function delete a task from the list of task
     * @param index an Int representing the position of the deleted task
     * @return nothing
     * @author Anwar
     */
    override fun deleteTaskAt(index: Int) {
        DataManager.deleteTaskAt(index)
        adapter.setData(DataManager.tasks)
    }
    //endregion
}